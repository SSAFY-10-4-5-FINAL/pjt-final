<script setup>
import { ref } from "vue";
import ApartRightUnder from "./right-items/ApartRightUnder.vue";
import ApartSearchList from "./right-items/search_list/ApartSearchList.vue";

// Data
const inputText = ref("");
</script>

<template>
  <div class="container-fluid" id="right-bar">
    <div class="search-select-wrap item">
      <div id="toggle-btn-wrap">
        <span class="toggle-text">아파트</span><button id="toggle-btn">toggle</button
        ><span class="toggle-text">지역</span>
      </div>
      <div class="search-input-liner">
        <div class="input-wrap">
          <input type="text" placeholder="지역, 아파트 검색" v-model="inputText" />
        </div>
        <div class="btn-search-wrap"><button class="btn-search"></button></div>
      </div>
      <div id="star-link">
        <span>빠른 검색</span><br />
        <RouterLink :to="{ name: 'ApartList' }"><a href="#">관심 아파트</a></RouterLink
        ><span> | </span>
        <RouterLink :to="{ name: 'ApartDetail' }">
          <a href="#">관심 지역</a>
        </RouterLink>
      </div>
    </div>
    <div class="list-detail-wrap item">
      <ApartRightUnder />
    </div>
    <div v-show="inputText !== ''" id="apart-search-list-wrap"><ApartSearchList /></div>
  </div>
</template>

<style scoped>
@import "./css/right.css";
</style>
