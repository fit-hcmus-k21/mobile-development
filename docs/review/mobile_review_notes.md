6. localization ? trình bày bằng các ngôn ngữ khác nhau
7. states life cycle service: start, running, destroyed
8. Hộp thoại and hỗ trợ: alert - progress - datepicker - timepicker/dialog
9. AIDL ? Android Interface Definition Language: ngôn ngữ định nghĩa giao diện
11. And hỗ trợ exception nào? Inflate, Surface.OutOfResource, 
				SurfaceHolder.BadSurfaceType, Window.manager.BadToken

12. MIME type ? :Text/html
13. ExpandableListView được sử dụng cho : Tree Creation
14. Các phần là thư viện gốc and:
	- webkit, openGL, SQLite
15. Ứng dụng giám sát email: Mailbuzz
16. Các thành phần của tệp APK: Resources, Delvik Executable

17. BLOB là gì ? Binary Large Objects
19. Kiểu chữ tùy chỉnh của android được gọi là: Norad 
20. Có thể đặt menu ở chế độ tắt theo bảng chữ cái bằng cách???
   - The menu can be placed into alphabetic shortcut mode by calling : setQwertyMode()

23. HDH And cung cấp những services nào: 
	- lacation : viền ?, sensor reading: cảm biến đọc, wifi...
	
25. Loại thông báo nào có sẵn trong And:
	- Toast, status bar, dialog, (kh có Alert notification)
26. And có hỗ trợ AWT và Swing không? => không
	- AWT và Swing là gì ?
27. notificationManager là 1 System service
28. Để cập nhật nội dung của Content Provider sử dụng curser và commit bạn cần gọi?
	- commitUpdates()

29. AAPT: Android Asset Packaging Tool
30. Package classes giúp truy cập mạng trong And: Android.net
33. Để chèn dữ liệu vào Content Provider thì bạn cần sử dụng: BulkInsert

34. Phương thức lưu trữ dữ liệu có sẵn trong and:
	- Shared Prefs, Internal - External Storage
	- SQLite db, network connection
36. Lớp nào chứa hằng số trong đặc tả MTP và PTP ? => MtpConstants
	- MTP /PTP là gì ?

37. Tập lệnh nào được dùng để xây dựng và cài đặt ứng dụng trên thiết bị? Build.xml
38. Để xây dựng ứng dụng And cần SDK, vậy JDK để làm gì?
39. And có đưa ra giả định về kích thước màn hình thiết bị, độ phân giải hay chipset không ?: Không

40. Đối với Wifi Driver (trình điều khiển wifi), mã được sử dụng bởi And không phải là mã nguồn mở
41. Đối với tài liệu MIME Text/html, mã hóa sẽ ở dạng : UTF-8
42. ANR: app not responding

43. Trong ..., sender chỉ định loại người nhận => Implicit intent : Ý định ngầm ???
44. Các nickname của các phiên bản Andr: 
	- cupcake, honeycomb, gingerbread
45. .dex ? Dalvik Executables

46. Nếu sử dụng các tool mà not and-enabled, bạn có thể dùng ... script được tìm thấy trong cài đặt SDK
	=> ActivityCreator.py
48. Compiler cho and code: Dex compiler
51. Base class cho tất cả các classes and: Object
52. Dùng Content Provider, có thể thực hiện - create/ read/ update/ delete


53. Nghĩa của SIP? Session initiation protocol
54. Dex compiler compiles và convert src code thành a byte code được gọi : Delvik byte code
55. Để nhận instance của menu, dùng onCreateOptionsMenu()

56. Ta dùng phương thức nào để lấy root của tree: getRootView()
57. AVD stands for: Android Virtual Device
59. Resources nào dùng trực tiếp từ available resources: Style ??

61. For Date/Time manipulation which packages is used in android: Util
63. kiểu DL nào được hỗ trợ bởi AIDL ?	=> C
   A. String,  B. List,  C. Map,  D. All native java data type
64. IPC stand for: Inter Process Communication
65. And dùng cả content, ... and the ... type as ways to identify content trên thiết bị
	=> Content URI, MIME type

66. ADB stand for: ? Android Debug Bridge
67. "values subfolder có ... mà define constraint value -> XML
68. Những tools nào used to test app: ? -> 1, 2, 3 ???
   1. Physical And phone., 2. SDK, 3. third party emulator, 4. JDK, 5. winrunner
69. ... is a means of interaction with activities hay other android components => IPC:  Inter process communication

70. Package nào cần để viết And test cases ? android.test
71. Source code nào mà android app sử dụng convert thành Delvik executable?  Java src code
72. And provides vài standard themes, liệt kê ở ... -> R.style

73. Browsers mà có sẵn cho and dựa trên: open source webkit
75. ... field provides automatic spelling assistance -> android:autoText
76. APK package chứa ... files : .dex 

77. Nếu bạn cung cấp 1 ..., your choise identifier(second param) can be 0 :  Runable
78. Exception ném ra khi 1 package, app, component đã cho canot be found: PackageManager.NameNotFoundExeption
79. Để viết and code dùng c/c++, bạn cần dùng: Android NDK : Native Dev Kit

80. The time making the network call UI is sluggish hay gets crash do: network latency
85. Google Licensed vài proprietary apps true or false? True
95. And build open the Java Micro Edition (J2ME) version of java true of false ??? False

107. Cái nào kh phải là 1 phần của and native libs: Dalvik
108. Năm phát triển Dalvik VM bắt đầu: ??? 2005
109. Key diff với distribution of apps for And based devices than other mobile device platform app: ???
=> apps are distributed by multiple vendors with diff policies on apps

112. BMGR tool used to ??? : Backup Manager Cmd tool, used for managing the device data backup and restore
113. Foreground service : => d
a. bắt đầu khi call foreground()
b. may or may not provide a notification for the status bar
c. notification cant be dismissed unless the service is either stopped or removed from the fg
d. both a and c

114. A1,A2,A3,A4 là các activities called dùng intents, then A1-A4-A2-A3. A4 call A2 với flag FLAG_ACTIVITY_NO_HISTORY, 
khi finish() method is called on A3, what will be the current running activity? => A4

115. A1,A2,A3,A4 là các activities called dùng intents, then A1-A2-A4-A3. A2 call A4 với flag FLAG_ACTIVITY_CLEAR_TOP, khi finish thì call A3
what will be current running activity ? => 

116. A1,A2,A3,A4 là các activities called dùng intents, then A1-A2-A3-A4. A3 call A4 với no intent flag, khi fnish call A4
what will be current activity ? => A3

117. Dấu + trong android:id="@+id/my_id"? => create a new id and add to resources
118. khi bạn muốn hệ thống chạy dịch vụ vô thời hạn bằng cách khởi động lại dịch vụ khi bị tắt, hãy sử dụng > START_STICKY
119. Hệ thống And use intent để: broadcast system intents

120. Màn hình tắt là ví dụ của: normal broadcast
121. Nếu truy cập vào column không tồn tại: SQLException
122. Maximum result returned by getFromLocationName() là: 5
123. Method startForeground() và stopForeground() được giới thiệu ở : API level 5 (Android 2.0)

124. should always first check avalability of audio effects by calling the following method on corresponding audio effect class:
a. ischeckable() , b. isavailable() , c. isvaluable(), d. iscaview() => B

125. App require filtering based on screen size can use the attributes: 
a. <supportmultiple-screens>
b. <supports-screens>
c. <supportall-screens>
d. supportevery-screen
=> B

126. what is false with respect to onBind()
a. is called when another component wants to bind with a service
b. calling startService() result in a call to onBind()
c. if u don't want to allow binding then return null
d. if u want to allow binding then return binder object
=> B

127. phần nào của android platform là open source: => A, C, D
A. low level linux modules, B. tất cả , C. Native libs, D. App framework, E. complete apps

139. How can I check if an activity already running before starting it ?
A. NEW_TASK_LAUNCH in the startActivity() call
B. FLAG_ACTIVITY_NEW_TASK 
C. FLAG_ACTIVITY_SINGLE_TOP
D. By using category android: name="android.intent.category.LAUNCHER"/>
=> C

140. dialog boxes hỗ trợ ở Android 5
158. Intent filter có tags nào: action, data, category...
161. Nếu người dùng leaves 1 task for long time: > system will clear task of activities except root activity

167. Activity results handled by the onActivityResult khác với on another using parameter? => D
A. Request code, B. Ressult code, C. Data, D. both a and c

168. Broadcast receiver là gì? => The dont display a UI
169. Which of the following strings is a correct XML name ?
A. _myElement, B. myElement, C. #myElement, D. None above

173. XML tags are case sensitive true or false? > True
174. In XML, WWhat is identified by a URI reference: > XML namespace
175. What are the predefined attributes: => C
a. xml:lang, b. xml:space, c. both a and b, d. none above
_________________
4. what was Google main business motivation for supporting android > To allow them to advertise more
6. From a phone manufaturer point of view, what makes and so great > aside from some specific drivers, it provides everything to make a phone work
15. Android doesn’t make any assumptions about a device’s screen size, resolution, or chipset.: True

27. When you distribute your application commercially,you’ll want to sign it with your own key. > True
32. Android Applications must be signed. > before they are installed
40. The Emulator is identical to running a real phone EXCEPT when emulating/simulating what? > Sensors

41. How is a simulator different from an emulator?
=> the emulator imitates the machine executing the binary code, rather than simulating the behavior of the code at a higher level.
45. The Android SDK ships with an emulator. > True
53. Which of the following is the most “resource hungry” part of dealing with Activities on Android
=> Opening a new app
54. What runs in the background and doesn’t have any UI components? > Services

56. When an activity doesn’t exist in memory it is in. > Starting state
57. Which of the following is NOT a state in the lifecycle of a service? > Paused 
58. There is no guarantee that an activity will be stopped prior to being destroyed. > True

59.	Intents
A.	are messages that are sent among major building blocks
B.	trigger activities to being, services to start or stop, or broadcast
C.	are asynchronous
D.	all of these
Answer» D. all of these

60.	In an explicit intent, the sender specifies the type of receiver. > false

61.	an implicit intent is the sender specifies the type of receiver? > true

63.	An activity in a stopped state is doing nothing. > false

64. Application contexts are independent of the activity life cycle. > true

66. Broadcast receivers are Android’s implementation of a system-wide publish/subscribe mechanism, or more precisely, what design pattern?
Answer» A. observer

67. There can be only one running activity at a given time. > true

68. YAMBA stands for Yet Another Mobile Banking App. > false

73. What will services be used for in the Yamba project?
Answer» B. it will update tweets periodically in the background

74.	Which answer is not part of the design philosophy talked about in chapter five?
Answer» C. lagre increments

75.	App Widgets are can be place on the home screen by the user to check for updates are available? > true

76. The android OS comes with many useful system services, which include processes you can easily ask for things such as your..
A.	all of these and more.
B.	location
C.	sensor readings
D.	wifi? hot spots
Answer» A. all of these and more.

77. What does the Gargenta mean in his Design Philosophy when he says that the project will, “Always be whole and complete”?
Answer» C. he means that we will work on the program by adding self contained chunks to it so that at every stopping point the application runs as though it were a whole and complete application. each additional chunk simply adds a new functionality to the application.

78. An Android application is a loose collection of content providers, activities, broadcast receivers, and services.
Answer» A. true

79. Which of the following is NOT an activity we will be creating for the YAMBA project?
Answer» B. update activity

80. The timeline receiver will receive messages from the Android system. > false

81. Status data will be exposed to the rest of the Android system via: > content provider

83. How does Gargenta approach the problem of the app acting sluggishly due to network latency? > multithreading


1. View pager dùng cho? Swiping Fragments
2. Nesting in layouts được supported  trong And:
	- được phép có những layout inside another layout
3. có thể add views vào layout dynamically không ?
	- Yes: bằng các methods: addView(), inflate() cho phép tạo và thêm views programmatically at runtime

4. Cái nào không belong to transitions: ViewSlider không phải là standard transition class trong And
	+ Not included in the And SDK and not belong to the set of predefined transition classes
   - Còn lại ViewSwitcher, ViewFlipper, ViewAnimator: all valid transition classes in And

5. In nine path image, corners là: Not scalable
- Có nghĩa là nội dung within corners của ảnh sẽ remain fixed và cannot be stretched or resized khi img is scaled
- Đảm bảo rằng elements or design within img như borders, patterns duy trì những original proportions và xuất hiện bất chấp img size

6. Fragment is not a part of activity ?
=> False: fragment is indeed a part of an activity trong And dev
- Frag là modular sections của 1 activity mà có thể combined hay reused trong diff activity

7. Action bar can be associated to ? Only activities
=> Nó là 1 UI components mà cung cấp consistent navigation và menu opts cho user within an activity
- Frag, dont have their own action bar

8. Rating bar can be resize? No

9. Depricated components : Absolute Layout since API level 3

10. Fragment not included in API level 8 hay lesser, nó được intro in API level 11 (HoneyComb)


1. Folder do you copy paste an image into ? Drawable
2. Correct for using an img with tên trainstation: android:src="@drawable/trainstation"
3. The virtual device was set up to support the system image of Marshmallow ????

4. And is licensed under which open source licensing : Apache/MIT: cho phép freely use, modify, distribute 
5. Open Handset Alliance là người sở hữu And platform, not Google , announced in 2007
6. Versions 1.6 hay 2.0 là minimum development target ...

7. first phone run And OS: T-Mobile G1
8. Google mua And khi nào: 2005
9. Android release since 1.5 có nicknames derived from Food:
	- v1.5: cupcake | v1.6: Donut | v2.0: Eclair ...

10. And v1.5 có greatest share as market of January 2011
11. Dalvik VM started 2005
12. Java byte code is compiled into Dalvik byte code

13. 3 components chính của APK: Dalvik Executable, Resources, Native Libs

14. AWT và SWing libs bị removed từ And Lib Set
	- AWT: Abstract Window Toolkit
	- SWing:
- Hai này là java libs, dùng để tạo GUI trên desktop app, kh tương thích với And OS

15. R.java được tạo tự động bởi And build process, chứa ref tới layouts, strings, images, ghi đè lần khác

16. simulator khác emulator? 

1. SDK include tutorials, debugger, sample code.
2. Android debug bridge là gì ? A toolkit cho phép: install, uninstall app, access logs, transfer files, run shell cmd
3. A fastboot: a diagnostic protocol


1. Class should ur view extend so you can draw on it: SurfaceView
2. Interface used to listen for changes in views state: SurfaceHolder.Callback
3. Game view: FrameLayout

4. Method ovverride khi extend Thread class: Run
5. Name of obj class within game view that u draw on: Canvas
6. drawRect take (Rect obj, Paint obj)

7. surfaceCreated use for: start the game thread
8. FCM: Firebase Cloud Messaging
9. class used to receive wifi scanning result: BroadcastReceiver

10. unregisterReceiver() : onStop()
11. Thư viện cần import để tương thích với API 11 và trên: Import android.support.v4.app.*;
12. Phương thức khởi tạo Fragment: OnCreateView()

13. Fragment có lifecycle riêng ?: Có
14. Tại sao Fragment Manager used: for transaction between fragments
15. Fragment Manager used for actions: add, remove, delete

16. Fragment use getActivity instead of MainActivity.this
- Dùng Main...this có thể cause issues vì cùng time, có thể nó đang associated với nhiều activity
17. 1 activity có thể có nhiều fragments, mỗi cái đại diện cho part khác nhau của UI hay tính năg
18. funcs in asyncTask: OnPreExecute, DoInBackgroud, OnProgressUpdate, OnPostExecute

19. cách store heavy structured data: SQLite db
- Shared Prefs: dữ liệu nhỏ, Cursor: result set returned by a db query 
20. Cách fix crash using log cat: Log cat chứa exception name cùng với số dòng
21. Fragment lifecycle trong And: OnAttach -> OnCreate -> OnCreateView -> OnActivityCreated -> OnStart -> OnResume

22. GamePanel extend ? : SurfaceView
23. Tín hiệu user đã lift finger khỏi screen: MotionEvent.ACTION_UP
24. Hai tham số mà MainThread lấy: SurfaceHolder và GamePanel

25. Khi tạo 1 game Obstacles, tham số nhận là: Width, Height, Colour, Starting X pos, Starting Y Pos
26. method used by Main Thread to make change Game Panel: Update()
27. Main thread use ... to lock the game framerate to 30fps: System.nanotime()

28. Objs implement GameObject interface: Rectangle player, Obstacle
29. Class nào mà SurfaceView implement để listen for changes on the drawable surface: SurfaceHolder.CallBack()


1. Vị trí lưu trữ csdl mặc định thiết bị của ƯD là: Data/Data/Package_name/Databases
2. Có thể sử dụng lệnh nào để khởi động Service: 
3. Khi nào contentProvider được kích hoạt: sử dụng content Resolver
4. Lớp cha của Service là: ContextWrapper

5. Sự khác biệt activity context và app context ?
=> Activity context được gắn với vòng đời của 1 activity , app context ắn với vòng đời ứng dụng

6. Component nào không được kích hoạt bởi 1 intent: contentProvider
7. Phù hợp lưu trạng thái ứng dụng: Activity.onPause()
8. Cái nào kh liên quan Fragment class: cursorFragment

9. Giới hạn thời gian của broadcast receiver trong android là: 10s
10. Sự khác biệt Android API và Google API:
=> GG APi gồm Google Maps và các thư viện khác cho Google, Android API chỉ bao gồm các thư viên android
11. onClick thực sự là property

12. Trong table layout, column được hiểu dựa vào đối tượng: thông qua SL view trong table row
13. Môi trường Java cần thiết để phát triển là > JDK
14. Phương thức dùng để lưu trữ dữ liệu vào Share Prefs: Editor.commit()

15. PT được gọi khi service được tạo lần đầu tiên bằng cách dùng onStartCommand() hay onBind() là > onCreate()
16. Một loại dịch vụ được cung cấp bởi Android giúp tạo giao diện người dùng > View System
17. Hoạt động chính cho app phải được khai báo trong <intent-filter>
18. Lớp con trực tiếp của Activity là > FragmentActivity, ActivityGroup, ListActivity
