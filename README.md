# Java Android Towns App
A simple Android application for managing a list of towns with weather information.

## Project Requirements
- Android Studio Chipmunk | 2021.2.1 or newer
- Minimum SDK: Android 11.0 (API level 30)
- Target SDK: Android 11.0 (API level 30)
- Java 1.8

## Dependencies
- AndroidX AppCompat 1.3.1
- Google Material Design Components 1.4.0
- AndroidX ConstraintLayout 2.1.0
- AndroidX Legacy Support v4 1.0.0

## Architecture & Design Patterns
The project implements:
- **Adapter Pattern**: Used in RecyclerView implementation to convert data objects into view items
- **ViewHolder Pattern**: Optimizes list performance by caching view references

The application uses RecyclerView, a powerful Android UI component that combines the Adapter and ViewHolder patterns for efficient list handling and memory usage.

## Setup Instructions
1. Clone the repository
2. Open project in Android Studio
3. Wait for Gradle sync to complete
4. Run on an emulator or device with Android 11.0 (API 30) or higher

## Features & Usage Guide
### View Towns
- The main screen displays a list of towns with their current temperatures
- Each town's temperature updates automatically
- Click on any town name to see its current weather status in a bottom popup

### Manage Towns
- **Delete a Town**: Press the "Delete" button next to any town to remove it from the list
- **Add a New Town**: 
  1. Click the floating round "Add" button
  2. A popup window will appear
  3. Enter the new town details
  4. Click "Save" to add the town or "Cancel" to close without saving

### Weather Features
- Each town displays a dynamic temperature that changes over time
- Weather status is shown when interacting with town names
