//1.首先相对布局下摆放两个TestView、两个Edit，两个按钮

//1.1点击登录按钮消息框的弹出
Button LoginBtn = (Button)findViewById(R.id.LoginBtn);
		LoginBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("确定");
				builder.setMessage("该按钮被点击!");
				builder.setPositiveButton("是", null);
				builder.show();
				
			}
		});
