
App Architecture:

This app is written using MVVMi Reactive Clean Architecture with dependency injection. The purpose of this architecture is to enable:
- Highly and effectively testable. As every layer apart from the views are not dependant on android framework codes, it allows for each of the layers to be testable as JVM tests which are quick and targeted.
- Dependency Injection to allow for easy mocking of dependencies to test each component effectively
- Separation of concerns to put the right code into the right layers and groupings
- Modular components to improve testability, scalability and reuse
- Scalability. Having codes that are modular and well separated enables developers to quickly add new features or change existing code without causing regression defects

The layers are separated in the following way:
- Views(Activity/Fragment) - only used to display data to the users and does not have conditional logic. This makes UI tests targeted, small and quick
- ViewModel - handles UI data logic. Prepares the data to be passed back to corresponding view and handles threading logic to enable views to remain snappy at all times
- Interactor - Handles business logic. Interacts with the data layers to get the relevant data and sanitizes, combines and filter the data for the feature/use case
- Repository - Provides a clean interface for the app to interact with the data layers therefore abstracting the data layer effectively
- Api/Database - The implementation for the data layers

It's important to note that there is not a single correct way to implement android architecture and it depends a lot on the use cases, team structure and tooling availability but generally as long as the desired outcome is achieved the specific implementation is less important


Libraries used:

- Android Architecture Components - ViewModel, LiveData
- RxJava2 - Reactive observable mechanism and threading management
- Retrofit - Networking library
- Dagger2 - Dependancy injection

Todo:

- Improve the UI rendering of the recycler view items as this example only attempted to showcase the logic
- Implement the actual test code. JUnit tests for each of the layers (viewmodel, interactor, repository, api), Roboletrics/espresso test for the view layer, and espresso test for the integration test layer
- Proper error handling for failure cases