<template>
    <div class="panel">
        <!-- Default panel contents -->
        <div class="panel-heading">Order Lists</div>
        <!-- Table -->
        <table class="table is-fullwidth">
            <thead>
            <tr>
                <th>ID</th>
                <th>ProductID</th>
                <th>OrderDate</th>
                <th>UnitPrice</th>
                <th>Amount</th>
                <th>SendAddress</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="order in orderList" :key="order.id">
                <td>{{order.id}}</td>
                <td>{{order.productID}}</td>
                <td>{{order.orderDate.toDateString()}}</td>
                <td>{{order.unitPrice}}</td>
                <td>{{order.amount}}</td>
                <td>{{order.sendAddress}}</td>
                <td><detail-modal :instance="order"></detail-modal></td>
                <td><update-modal :instance="order" target="order"></update-modal></td>
                <td><delete-modal :instance="order" target="order"></delete-modal></td>
            </tr>
            </tbody>
            <tfoot>
                <tr><add-modal :instance="orderInstance" target="order"></add-modal></tr>
            </tfoot>
        </table>
    </div>
</template>

<script>
    import Axios from 'axios';
    import addModal from '../common/AddModal'
    import detailModal from '../common/DetailsModal'
    import updateModal from '../common/UpdateModal'
    import deleteModal from '../common/DeleteModal'

    export default {
        mounted(){
            Axios({
                method: 'get',
                url: '/order/query/all',
                baseURL: 'http://localhost:8082',
            }).then(response=> {
                console.log(response)
                response.data.forEach(item=>{
                    item.orderDate = new Date(item.orderDate)
                    item.sendDate = new Date(item.sendDate)
                });
                this.orderList = response.data
            }).catch(error=>{
                console.warn(error)
                alert(error)
            })
        },
        components:{
            addModal,
            detailModal,
            updateModal,
            deleteModal,
        },
        data(){
            return{
                orderList:[],
                orderInstance:{
                    id:'Number',
                    productID:'Number',
                    memberID:'Number',
                    orderDate:'Date',
                    unitPrice:'Number',
                    amount:'Number',
                    sendDate:'Date',
                    sendAddress:'String'
                }
            }
        },
        // computed:{
        //     productDictList () {
        //         return this.$store.getters.productDictList;
        //     },
        // },
        // methods:{
        //     showProductName(productID){
        //         return this.productDictList[productID]['name']
        //     }
        // }
    }
</script>

<style scoped>

</style>
