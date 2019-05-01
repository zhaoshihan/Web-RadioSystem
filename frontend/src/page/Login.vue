<template>
  	<div class="login_page fillcontain">
	  	<transition name="form-fade" mode="in-out">
	  		<section class="form_contianer">
		  		<div class="manage_tip">
		  			<p>elm后台管理系统</p>
		  		</div>
		    	<form :model="loginForm" :rules="rules" ref="loginForm" @submit.prevent="checkStaff">

					<div class="field">
						<div class="control">
							<label for="account" class="label">用户名：</label>
							<input v-model="loginForm.account" type="text" class="input" id="account" name="account"
									placeholder="Username">
						</div>
						<div class="control">
							<label for="password" class="label">密码：</label>
							<input v-model="loginForm.password" type="password" class="input" id="password" name="password"
								   placeholder="Password">
						</div>
						<div class="control">
							<button type="submit" class="submit_btn">登录</button>
						</div>
					</div>
				</form>
				<p class="tip">温馨提示：</p>
				<p class="tip">未登录过的新用户，自动注册</p>
				<p class="tip">注册过的用户可凭账号密码登录</p>
	  		</section>
	  	</transition>
  	</div>
</template>

<script>
	import Axios from 'axios';

	export default {
	    data(){
			return {
				loginForm: {
					account: '',
					password: '',
				},
				rules: {
					username: [
			            { required: true, message: '请输入用户名', trigger: 'blur' },
			        ],
					password: [
						{ required: true, message: '请输入密码', trigger: 'blur' }
					],
				},
			}
		},
		methods: {
			checkStaff: function () {
				Axios.defaults.headers.post['Content-Type'] = 'application/json';
				var formData = JSON.stringify(this.loginForm)
				console.log(this.loginForm)
				alert(this.loginForm.account + this.loginForm.password)
				Axios({
					method: 'post',
					url: '/staff/check/',
					baseURL: 'http://localhost:8082',
					params: this.loginForm
				}).then(response=> {
					console.log(response)
					console.log(response.status)
					alert("login success")
					this.$router.push('staff_home')
				})

				// Axios.post("http://localhost:8082/staff/check/", {
				// 	params:{
				// 		account: "zsh",
				// 		password:"123"
				// 	}
				// }).then (response=>{
				// 	console.log(response)
				// 	alert(response)
				// 	let status = response.status
				// 	// if (status === 302) {
				// 	// 	this.$message({
				// 	// 		type: 'success',
				// 	// 		message: '登录成功'
				// 	// 	});
				// 	// 	this.$router.push('/StaffHome')
				// 	// } else {
				// 	// 	this.$notify.error({
				// 	// 		title: '错误',
				// 	// 		message: '请输入正确的用户名密码',
				// 	// 		offset: 100
				// 	// 	});
				// 	// }
				//
				// })
			},
		}
	}
</script>

<style scoped>
</style>
