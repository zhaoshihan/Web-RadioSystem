<template>
    <nav class="navbar is-transparent">
        <div class="navbar-brand">
            <a class="navbar-item" href="https://bulma.io">
                <img src="https://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox" width="112" height="28">
            </a>
        </div>

        <div id="navbarExampleTransparentExample" class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="https://bulma.io/">
                    Home
                </a>

                <a class="navbar-item" href="#">
                    Docs
                </a>

                <a class="navbar-item" href="#">
                    Picture
                </a>
            </div>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <p class="subtitle">Welcome, {{getUserName}}</p>
            </div>
            <div class="navbar-item">
                <a class="button is-primary" @click="logOut">
                    <strong>Log Out</strong>
                </a>
            </div>
        </div>
    </nav>
</template>

<script>
    export default {
        computed:{
            getUserName(){
                return this.$store.state.global.currentUser['name'];
            }
        },
        methods:{
            logOut(){
                this.$store.commit('LogOut')
                this.$router.push('/login')
            }
        }
    }
</script>

<style>

</style>
