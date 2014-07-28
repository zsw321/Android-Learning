//1.首先相对布局下摆放两个TestView、两个Edit，两个按钮

//1.1 学习如何获取文本框内容、设置文本框内容，弹出消息框
//步骤：在账号编辑框输入内容，点击登录按钮，将输入的内容设置到密码编辑框， 并将内容以消息框弹出

Button LoginBtn = (Button)findViewById(R.id.LoginBtn);
LoginBtn.setOnClickListener(new OnClickListener() {
			
public void onClick(View v) {
// TODO Auto-generated method stub
	EditText LoginText = (EditText)findViewById(R.id.NameEdit);
	strLoginName = LoginText.getText().toString();           //strLoginName为成员函数，声明为String变量
				
	EditText PasswdText = (EditText)findViewById(R.id.passwdEdit);
	PasswdText.setText(strLoginName);
				
	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("确定");
		builder.setMessage(strLoginName);
		builder.setPositiveButton("是", null);
		builder.show();
				
				
	}
});


//2.利用SQLite创建数据库Login.db，并创建一张表person，表中字段name(varchar), passwd(varchar)。
//打开或创建Login.db数据库  
	//2.1 创建或打开数据库Login.db
	SQLiteDatabase db = openOrCreateDatabase("Login.db", Context.MODE_PRIVATE, null);
	db.execSQL("DROP TABLE IF EXISTS person");
	
	//2.2 创建person表
	db.execSQL("create table person (name varchar primary key, passwd varchar)");
	
	//2.3 插入数据  (创建类Person)
	
	//第一种：利用execSQL执行
        Person person = new Person();  
        person.name = "zsw321";  
        person.passwd = "zsw123";  
        db.execSQL("INSERT INTO person VALUES (?, ?)", new Object[]{person.name, person.passwd});   
        
        //第二种：ContentValues以键值对的形式存放数据  
        person.name = "david";  
        person.passwd = "33";  
        ContentValues cv = new ContentValues();  
        cv.put("name", person.name);  
        cv.put("passwd", person.passwd);  
        //插入ContentValues中的数据  
        db.insert("person", null, cv);  
          
        //第三种：更新数据 
        cv = new ContentValues();  
        cv.put("passwd", "35");  
        //更新数据  
        db.update("person", cv, "name = ?", new String[]{"david"});  
       
	//删除的数据库test.db
	//deleteDatabase("login.db");
        db.close();
        
       
//3. 通过读取账号、密码文本框，查询数据库，判断是否存在该记录， 

      //3.1. 首先先一个查询接口函数，输入账号、密码，返回记录的条数
      //通过给定的name,passwd查询数据库是否有该记录
      public int queryResult(String name, String passwd){
    	//打开或创建Login.db数据库  
    	SQLiteDatabase db = openOrCreateDatabase("Login.db", Context.MODE_PRIVATE, null);
    		
    	Cursor c = db.rawQuery("select * from person where name = ? and passwd = ?", new String[]{ name, passwd});
    	int count = c.getCount();
    		
    	c.close();
    	db.close();
    	return count;
     }
     
     //3.2. 读取账号、密码文本框，并查询数据库，通过消息框输出结果
     //2.点击按钮消息框的弹出
     Button LoginBtn = (Button)findViewById(R.id.LoginBtn);
     LoginBtn.setOnClickListener(new OnClickListener() {
			
	public void onClick(View v) {
	// TODO Auto-generated method stub
				
		String loginName, loginPasswd;
		EditText LoginText = (EditText)findViewById(R.id.NameEdit);
		loginName = LoginText.getText().toString();
				
		EditText PasswdText = (EditText)findViewById(R.id.passwdEdit);
		loginPasswd = PasswdText.getText().toString();
				
		int count = queryResult(loginName, loginPasswd);
				
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
		if(count > 0)
		{
			builder.setTitle("确定");
			builder.setMessage(loginName + "is right!");
			builder.setPositiveButton("是", null);
		}
		else
		{
			builder.setTitle("确定");
			builder.setMessage(loginName + "is wrong!");
			builder.setPositiveButton("是", null);
		}
			builder.show();
	}
     });
     
     //******在进行文本框内容读取过程中，对于空格没有做特殊处理，空格也属于内容的一部分******//
	
    
    
    

     
        
        
        
        
