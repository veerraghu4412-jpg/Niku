# Niku - Android Calendar (scaffold)

This branch contains a scaffold for a Calendar app built with Kotlin + Jetpack Compose.

Branch: feature/calendar-android-scaffold

What is included:
- Compose-based single-activity app
- Room entities, DAO and database
- Hilt DI module skeleton
- Simple MonthView & DayView composables
- ViewModel + Repository
- Reminder scheduler skeleton (WorkManager/AlarmManager placeholder)

How to open and run:
1. Clone the repo and checkout the branch:
   git clone https://github.com/veerraghu4412-jpg/Niku.git
   cd Niku
   git checkout feature/calendar-android-scaffold

2. Open the project in Android Studio (Arctic Fox or newer).
3. Let Gradle sync and then run the app on an emulator or device (minSdk 24).

Next steps I can implement for you on request:
- Add Add/Edit event screen and navigation
- Wire reminders using WorkManager and NotificationChannels
- Add recurrence (RRULE) helper and event expansion
- Google Calendar sync (OAuth + Calendar API)
- ICS import/export and home screen widget

If you want me to continue, tell me which feature to prioritize next and I'll implement it on this branch and push updates.
