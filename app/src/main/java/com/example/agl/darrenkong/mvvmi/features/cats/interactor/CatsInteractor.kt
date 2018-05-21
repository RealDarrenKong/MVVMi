package com.example.agl.darrenkong.mvvmi.features.cats.interactor

import com.example.agl.darrenkong.mvvmi.common.enums.GenderType
import com.example.agl.darrenkong.mvvmi.common.enums.PetType
import com.example.agl.darrenkong.mvvmi.common.repositories.PetsRepository
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatHeader
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatName
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatNameItem
import io.reactivex.Single
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by darrenkong on 16/5/18.
 */
class CatsInteractor
@Inject constructor(val petsRepository: PetsRepository) {

    fun getListOfCatsByGender(): Single<List<CatNameItem>> {
        return petsRepository.getPets()
                .flatMap({ pets ->
                    //filter out all pets that are not cats
                    val listOfCats = pets.filter { it -> it.petType == PetType.CAT }

                    //get a list of cats owned by male and sort them in alphabetical order
                    val listOfCatsOwnerByMale =
                            listOfCats
                                    .filter { it -> it.ownerGender == GenderType.MALE }
                                    .sortedWith(compareBy({ it.petName }))

                    //get a list of cats owned by female and sort them in alphabetical order
                    val listOfCatsOwnerByFemale =
                            listOfCats.filter { it -> it.ownerGender == GenderType.FEMALE }
                                    .sortedWith(compareBy({ it.petName }))


                    var dataList = ArrayList<CatNameItem>()

                    if (listOfCatsOwnerByMale.isNotEmpty()) {
                        dataList.add(CatHeader("Male"))
                        for (catOwnerByMale in listOfCatsOwnerByMale) {
                            dataList.add(CatName(catOwnerByMale.petName))
                        }
                    }

                    if (listOfCatsOwnerByFemale.isNotEmpty()) {
                        dataList.add(CatHeader("Female"))
                        for (catOwnerByMale in listOfCatsOwnerByFemale) {
                            dataList.add(CatName(catOwnerByMale.petName))
                        }
                    }

                    Single.just(dataList)
                })
    }
}