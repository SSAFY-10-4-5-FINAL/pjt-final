<script setup>
import { ref } from "vue";
import ApartList from "./right-items/ApartList.vue";

// Data
const inputText = ref("");
</script>

<template>
  <div class="container-fluid" id="right-bar">
    <div class="search-select-wrap item">
      <div id="toggle-btn-wrap">
        <span class="toggle-text">아파트</span
        ><button id="toggle-btn">toggle</button
        ><span class="toggle-text">지역</span>
      </div>
      <div class="search-input-liner">
        <div class="input-wrap">
          <input
            type="text"
            placeholder="지역, 아파트 검색"
            v-model="inputText"
          />
        </div>
        <div class="btn-search-wrap"><button class="btn-search"></button></div>
      </div>
      <div id="star-link">
        <span>빠른 검색</span><br />
        <a href="#">관심 아파트</a><span> | </span><a href="#">관심 지역</a>
      </div>
    </div>
    <div class="list-detail-wrap item"><ApartList /></div>
  </div>
</template>

<style scoped>
@import "./css/right.css";
</style>
