<div align="center">
  <h1>Project Demo</h1>
    <img width="25%" height="701" alt="image" src="https://github.com/user-attachments/assets/f365f456-8af7-40ae-bd3f-f12c2a25da00" /><br><br>

  ## 📱 Permissions Handling with EasyPermissions
  
  This implementation demonstrates the basic syntax and structure for handling runtime permissions in Android using the EasyPermissions library. The example covers camera permissions, which can be easily adapted for Location, Microphone, Bluetooth, and other permissions.

  <img width="50%" height="298" alt="image" src="https://github.com/user-attachments/assets/d1ba0389-6d4a-4c09-8b13-40a21e922860" /><br><br>

</div>
  
  ### Basic Syntax Structure
  
  #### 1. Permission Request Codes
  
  Before your class declaration, define constant values for each permission type. Each permission needs a unique integer identifier (1, 2, 3, etc.).
  
  #### 2. Permission Request Function
  
  The main function follows this structure:
  - Annotate with `@AfterPermissionGranted` and specify the request code
  - Check if permission is already granted using `EasyPermissions.hasPermissions()`
  - If granted: Execute the desired action (show toast, open camera, etc.)
  - If not granted: Request permission using `EasyPermissions.requestPermissions()` with:
    - **host**: The current activity context
    - **rationale**: A user-friendly explanation of why the permission is needed
    - **requestCode**: The constant identifier defined earlier
    - **perms**: The specific Android manifest permission
  
  #### 3. Button Click Listener
  
  In your `onCreate()` method, set up a click listener that calls your permission request function when the user taps the button.
  
  #### 4. Override Required Callbacks
  
  Implement three essential EasyPermissions callback methods:
  - **onRequestPermissionsResult**: Routes permission results to EasyPermissions
  - **onPermissionsGranted**: Handles the scenario when user grants permissions
  - **onPermissionsDenied**: Handles the scenario when user denies permissions
  
  ### Adapting to Other Permissions
  
  The same syntax structure applies to all permission types. Simply change:
  - The request code constant value
  - The manifest permission type (CAMERA → ACCESS_FINE_LOCATION, RECORD_AUDIO, BLUETOOTH_CONNECT, etc.)
  - The rationale message to explain why that specific permission is needed
  
  This consistent pattern makes it easy to implement multiple permissions throughout your application while maintaining clean, readable code.
