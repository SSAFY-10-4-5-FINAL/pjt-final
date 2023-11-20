<script setup>
import { ref, computed } from "vue";
import ApartRightUnder from "./right-items/ApartRightUnder.vue";
import ApartSearchList from "./right-items/search_list/ApartSearchList.vue";

// Data
const search = ref("");
let searchList = ref([]);
var debounce = null;

const searchedList = ref([
  {
    jname: "테스트 지역1",
  },
  {
    jname: "테스트 지역2",
  },
  {
    jname: "테스트 지역3",
  },
  {
    jname: "테스트 지역4",
  },
]);

// Function
const handleSearchInput = (e) => {
  search.value = e.target.value;

  if (search.value.length !== 0) {
    clearTimeout(debounce);
    debounce = setTimeout(() => {
      const filteredList = searchedList.value.filter((item) => item.jname.includes(search.value));
      searchList.value = filteredList;
    }, 500);
  } else {
    clearTimeout(debounce);
    debounce = setTimeout(() => {
      searchList.value = [];
    }, 500);
  }
};
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
          <input
            type="text"
            placeholder="지역, 아파트 검색"
            :value="search"
            @input="handleSearchInput"
            @keydown.tab="KeydownTab" />
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
    <div v-show="search.length !== 0" id="apart-search-list-wrap">
      <div v-for="value in searchList" id="apart-search-item">
        {{ value }}
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "./css/right.css";
</style>
