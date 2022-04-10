# Week 1

## Level 1

- SignInActivity
    - '로그인 버튼' 클릭 시 모든 EditText가 입력되어 있는 지 확인

      ```kt
       if (binding.etSignInId.text.isEmpty() || binding.etSignInPw.text.isEmpty()) {   
          
          //...
          
       }
      ```
    
    - 모든 입력이 되었을 때 로그인 버튼 클릭 시 HomeActivity로 이동

      ```kt
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
      ```

    - 비밀번호 EditText inputType 속성

      ```xml
        android:inputType="textPassword"
      ```

    - EditText hint 속성

      ```xml
        android:hint=""
      ```

    - 회원가입 버튼 클릭 시 SignUpActivity로 이동

      ```kt
        val intent = Intent(this, SignUpActivity::class.java)
        activityResultLauncher.launch(intent)
      ```


- SignUpActivity
    - '회원가입 완료' 버튼 클릭 시 모든 EditText가 입력되어 있는 지 확인

      ```kt
        if (binding.etSignUpName.text.isEmpty() || 
            binding.etSignUpId.text.isEmpty() ||
            binding.etSignUpPw.text.isEmpty()) {
          
          //...
          
        }
      ```
      
    - SignInActivity로 finish()로 이동

      ```kt
        finish()
      ```

    - 비밀번호 EditText inputType 속성

      ```xml
        android:inputType="textPassword"
      ```

    - EditText hint 속성

      ```xml
        android:hint=""
      ```


## Level 2

- 화면 이동
    - SignUpActivity
      ```kt
        binding.btnSignUpSubmit.setOnClickListener {
            if (binding.etSignUpName.text.isEmpty() || binding.etSignUpId.text.isEmpty() || binding.etSignUpPw.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                intent
                    .putExtra("id", binding.etSignUpId.text.toString())
                    .putExtra("pw", binding.etSignUpPw.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
      ```

    - SignInActivity

      ```kt
        
        private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
        
        ...
        
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val id = it.data?.getStringExtra("id")
                    val pw = it.data?.getStringExtra("pw")
                    binding.etSignInId.setText(id)
                    binding.etSignInPw.setText(pw)
                }
            }
      
        ...
        
        val intent = Intent(this, SignUpActivity::class.java)
        activityResultLauncher.launch(intent)
      
      ```

- HomeActivity 화면 레이아웃 수정
    - ScrollView 사용

      ```xml
        <ScrollView
            android:id="@+id/scroll_view_home"
            android:layout_width="0dp"
            android:layout_height="0dp"
            android:layout_marginTop="10dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/tv_home_mbti">
        
            ...
      
        </ScrollView>
      ```


- constraintDimensionRatio
    - height를 0dp로 설정하고 layout_constraintDimensionRatio에 1:1을 넣어서 width와 height를 1:1비율로 조정

  ```xml
    <ImageView
            android:id="@+id/iv_home_profile"
            android:layout_width="wrap_content"
            android:layout_height="0dp"
            android:layout_marginTop="40dp"
            android:scaleType="fitXY"
            android:src="@mipmap/ic_launcher"
            app:layout_constraintDimensionRatio="1:1"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
  ```


## Level 3
    
    추후 공개 예정...

<hr/>