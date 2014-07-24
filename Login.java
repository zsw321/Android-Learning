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
