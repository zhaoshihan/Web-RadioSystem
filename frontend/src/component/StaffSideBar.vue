<template>
  <aside class="menu">
    <p class="menu-label">
      Staff Administration
    </p>
    <ul class="menu-list">
      <li>
        <a>Menu</a>
        <ul>
          <li><a @click="chooseMemberList">Members</a></li>
          <li><a @click="chooseProductList">Products</a></li>
        </ul>
      </li>
    </ul>
  </aside>
</template>

<script>
export default {
    methods:{
      chooseMemberList() {
        this.$emit('changeBar', 'MemberList')
      },
      chooseProductList(){
        this.$emit('changeBar', 'ProductList')
      }

    }
}
</script>

<style>

</style>
