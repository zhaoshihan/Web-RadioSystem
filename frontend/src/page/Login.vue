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
		computed:{
	    	getAccount(){
	    		return this.loginForm.account;
			},
			getPassword(){
	    		return this.loginForm.password;
			},
	    	getPicked(){
	    		return this.loginForm.picked;
			}
		},
		methods: {
	    	validateForm: function(){
				if (typeof this.getAccount == "undefined" ||
						this.getAccount == null ||
						this.getAccount === "") {
					alert("account is null!")
					return false;
				}
				if (typeof this.getPassword == "undefined" ||
						this.getPassword == null ||
						this.getPassword === "") {
					alert("password is null!")
					return false;
				}
				return true;
			},

			login: function () {
				if(this.validateForm()){
					/* tmpUrl = "/member/check" or "/staff/check" */
					let tmpUrl = "/" + this.getPicked + "/check"
					// var formData = JSON.stringify(this.loginForm)
					console.log(this.loginForm)
					Axios({
						method: 'post',
						url: tmpUrl,
						baseURL: 'http://localhost:8082',
						auth: {
							username: this.getAccount,
							password: this.getPassword,
						},
						// params: this.loginForm
					}).then(response=> {
						console.log("In then method")
						console.log(response.data)
						if(this.getPicked === 'member'){
							this.$store.commit('memberLogin', response.data)
							this.$router.push('/member_home')
						}
						else if(this.getPicked === 'staff'){
							this.$store.commit('staffLogin', response.data)
							this.$router.push('/staff_home')
						}
					}).catch(error=>{
						console.warn("In catch method")
						console.warn(error)
						alert(error)
					})
				}
			},
			register:function () {
				alert("register function: " + this.getPicked)
				if(this.getPicked === "staff"){
					this.$router.push('/register_staff')
				}
				else if(this.getPicked === "member"){
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
