import store from './main'
const router = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        meta: {
            title: '登录'
        },
        component: (resolve) => require(['./page/Login.vue'], resolve)
    },
    {
        path:'/register_staff',
        meta:{
            title: '职员注册'
        },
        component: (resolve) => require(['./page/RegisterStaff.vue'], resolve)
    },
    {
        path:'/register_member',
        meta:{
            title: '会员注册'
        },
        component: (resolve) => require(['./page/RegisterMember.vue'], resolve)
    },
    {
        path: '/staff_home',
        meta: {
            title: '职员首页'
        },
        component: (resolve) => require(['./page/StaffHome.vue'], resolve),
        beforeEnter: (to, from, next) => {
            if(store.state.isStaff){
                next()
            }
            else {
                next('/login')
            }
        },
    },
    {
        path: '/member_home',
        meta: {
            title: '会员首页'
        },
        component: (resolve) => require(['./page/MemberHome.vue'], resolve),
        beforeEnter: (to, from, next) => {
            if(store.state.isMember){
                next()
            }
            else {
                next('/login')
            }
        },
    },
]

export default router
