<template>
    <div class="panel">
        <!-- Default panel contents -->
        <div class="panel-heading">Product Lists</div>
        <!-- Table -->
        <table id ="product_tb" class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Name</th>
                <th>Price</th>
                <th>Director</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="product in productList" :key="product.id">
                <td>{{product.id}}</td>
                <td>{{product.type}}</td>
                <td>{{product.name}}</td>
                <td>{{product.price}}</td>
                <td>{{product.director}}</td>
                <td>{{product.date.toDateString()}}</td>
                <td><detail-modal :instance="product"></detail-modal></td>
                <td><update-modal :instance="product" target="product"></update-modal></td>
                <td><delete-modal :instance="product"></delete-modal></td>
            </tr>
            </tbody>
            <tfoot>
            <tr><add-modal :instance="productInstance"></add-modal></tr>
            </tfoot>
        </table>
    </div>
</template>

<script>
    import Axios from '_axios@0.18.0@axios/index';
    import detailModal from '../common/DetailsModal'
    import updateModal from '../common/UpdateModal'
    import deleteModal from '../common/DeleteModal'
    import AddModal from "../common/AddModal";

    export default {
        components: {
            AddModal,
            detailModal,
            updateModal,
            deleteModal,
        },
        data() {
            return {
                productInstance: {
                    id: 'Number',
                    type: 'String',
                    name: 'String',
                    price: 'Number',
                    discount: 'Number',
                    habitat: 'String',
                    director: 'String',
                    superStar: 'String',
                    date: 'Date',
                    description: 'String',
                },
                productList: []
            }
        },
        mounted() {
            Axios({
                method: 'get',
                url: '/product/query/all',
                baseURL: 'http://localhost:8082',
            }).then(response => {
                console.log(response)
                response.data.forEach(item=>{
                    // console.log(item.date);
                    item.date = new Date(item.date)
                });
                this.productList = response.data
            }).catch(error=>{
                console.warn(error)
                alert(error)
            })
        },
    }
</script>

<style scoped>

</style>
