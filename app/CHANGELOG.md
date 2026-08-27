# What I changed in this update

Added Add/Edit event UI, navigation, and a simple reminder scheduler using AlarmManager and a BroadcastReceiver.

How to test the new features:
1. Checkout branch:
   git checkout feature/calendar-android-scaffold
2. Open the project in Android Studio and run the app on an emulator / device.
3. From Month View, open the navigation to the editor by launching the editor route (currently the MonthView placeholder doesn't have a button - you can launch the editor via code or I'll add a floating action button next).
4. In the editor, enter a title, set start/end time, and press Save. The app will schedule a reminder 10 minutes before the start time (if in the future).

Next steps I can take automatically on this branch if you want:
- Add FAB on MonthView to open EventEditor
- Show events on the MonthView grid
- Implement edit/delete flow
- Improve reminder UX and use WorkManager for less exact scheduling when exact alarms are not permitted

Reply with which next step you want me to implement and I'll push another commit.
