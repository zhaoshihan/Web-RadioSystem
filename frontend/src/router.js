const router = [
    {
        path: '/',
        redirect: '/member_home'
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
        component: (resolve) => require(['./page/StaffHome.vue'], resolve)
    },
    {
        path: '/member_home',
        meta: {
            title: '会员首页'
        },
        component: (resolve) => require(['./page/MemberHome.vue'], resolve)
    },
    // {
    //     path: '*',
    //     redirect: '/login'
    // },
]

export default router
