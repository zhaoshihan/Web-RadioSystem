<template>
	<section class="hero is-light is-fullheight">
		<div class="hero-body">
			<div class="container has-text-centered">
				<div class="column is-4 is-offset-4">
					<h3 class="title has-text-grey">Login</h3>
					<p class="subtitle has-text-grey">Please login to proceed.</p>
					<div class="box">
						<form :model="loginForm" ref="loginForm" v-on:submit.prevent>
							<div class="field">
								<label for="account" class="label has-text-left">Account：</label>
								<div class="control has-icons-left">
									<input v-model="loginForm.account" type="text" class="input" id="account" name="account"
										   placeholder="Username">
									<span class="icon is-small is-left">
									  <i class="fa fa-user"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<label for="password" class="label has-text-left">Password：</label>
								<div class="control has-icons-left">
									<input v-model="loginForm.password" type="password" class="input" id="password" name="password"
										   placeholder="Password">
									<span class="icon is-small is-left">
									  <i class="fa fa-lock"></i>
									</span>
								</div>
							</div>

							<div class="field">
								<div class="control">
									<label class="radio">
										<input type="radio" v-model="loginForm.picked" value="member">
										Member
									</label>
									<label class="radio">
										<input type="radio" v-model="loginForm.picked" value="staff">
										Staff
									</label>
								</div>
							</div>
							<p>选择的项是: {{loginForm.picked}}</p>
							<div class="field">
								<div class="control has-text-centered">
									<button class="button is-success" @click="login">Log In</button>&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="button is-link" @click="register">Sign Up</button>
								</div>
							</div>
						</form>
					</div>
					<p class="has-text-link">
						<a href="../">Sign Up</a> &nbsp;·&nbsp;
						<a href="../">Forgot Password</a> &nbsp;·&nbsp;
						<a href="../">Need Help?</a>
					</p>
				</div>
			</div>
		</div>
	</section>
</template>

<script>
	import Axios from 'axios';
	import 'bulma/css/bulma.css'
	import 'font-awesome/css/font-awesome.min.css'
	Axios.defaults.headers.post['Content-Type'] = 'application/json';

	export default {
	    data(){
			return {
				loginForm: {
					account: '',
					password: '',
					picked: 'member',
				},
			}
		},
		methods: {
	    	validateForm: function(){
				if (typeof this.loginForm.account == "undefined" ||
						this.loginForm.account == null ||
						this.loginForm.account === "") {
					alert("account is null!")
					return false;
				}
				if (typeof this.loginForm.password == "undefined" ||
						this.loginForm.password == null ||
						this.loginForm.password === "") {
					alert("password is null!")
					return false;
				}
				return true;
			},

			login: function () {
				if(this.validateForm()){
					/* tmpUrl = "/member/check" or "/staff/check" */
					let tmpUrl = "/" + this.loginForm.picked + "/check"
					// var formData = JSON.stringify(this.loginForm)
					console.log(this.loginForm)
					Axios({
						method: 'post',
						url: tmpUrl,
						baseURL: 'http://localhost:8082',
						auth: {
							username: this.loginForm.account,
							password: this.loginForm.password,
						},
						// params: this.loginForm
					}).then(response=> {
						console.log("In then method")
						console.log(response)
						alert("login status: " + response.status)
						let pushUrl = "/" + this.loginForm.picked + "_home"
						this.$router.push(pushUrl)
					}).catch(error=>{
						console.warn("In catch method")
						console.warn(error)
						alert(error)
					})
				}
			},
			register:function () {
				alert("register function: " + this.loginForm.picked)
				if(this.loginForm.picked === "staff"){
					this.$router.push('/register_staff')
				}
				else if(this.loginForm.picked === "member"){
					this.$router.push('/register_member')
				}
				else{
					alert("radio select error!")
				}

			}
		}
	}
</script>

<style scoped>
</style>
