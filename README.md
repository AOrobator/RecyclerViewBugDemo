# RecyclerViewBugDemo

This is a demo of the following bug in the support library: https://code.google.com/p/android/issues/detail?id=210148

Library used  
com.android.support:appcompat-v7  
com.android.support:recyclerview-v7  

Version used: 23.4.0  
Theme used: Theme.AppCompat.Light.DarkActionBar  
Devices/Android versions reproduced on: Nexus 6P Android 6.0.1  

- Relevant code to trigger the issue: https://github.com/AOrobator/RecyclerViewBugDemo  
- A screenrecord or screenshots showing the issue (if UI related) https://drive.google.com/file/d/0B-yFkNiHynDBSU9mQS1TcmFOWjQ/view?usp=sharing  

When swapping a single item using ItemTouchHelper and ItemTouchHelper.Callback, the RecyclerView is scrolled, yet the RecyclerView.OnScrollListener is not called.
