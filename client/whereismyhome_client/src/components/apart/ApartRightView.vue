<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { searchListDong, searchByDongCode } from "@/api/apart";
import { useAuthStore } from "@/stores/authStore";
import ApartRightUnder from "./right-items/ApartRightUnder.vue";

// Data
const router = useRouter();
const authStore = useAuthStore();

const search = ref("");
let searchList = ref([]);
var debounce = null;

const searchedList = ref([]);
const dongCode = ref(0);

// Function
// < ----------- 검색 리스트 ----------- >
const getSearchList = async (subdong) => {
  const response = await searchListDong(subdong);
  searchList.value = response.data; // searchList = {sidoName, gugunName, dongName, dongCode}
};

const handleSearchInput = (e) => {
  // 검색 단어 입력 시 500ms 이후에 api를 쏘고 받아온 걸 띄우기 위한 함수
  search.value = e.target.value;

  if (search.value.length !== 0) {
    clearTimeout(debounce);
    debounce = setTimeout(() => {
      getSearchList(search.value); // 서버에서 동 이름 가진 정보 가져옴
    }, 500);
  } else {
    clearTimeout(debounce);
    debounce = setTimeout(() => {
      searchList.value = [];
    }, 500);
  }
  // 동코드 저장 정보 변경
  if (searchList.value.length !== 0) {
    dongCode.value = searchList.value[0]["dongCode"]; // 제일 상위 지역의 동코드 저장
  } else {
    dongCode.value = 0;
  }
};

// < ----------- 검색 요청 ----------- >
const onSearchByDongCode = () => {
  if (dongCode.value === 0) {
    alert("검색할 곳을 입력해주세요");
  } else {
    search.value = "";
    router.push({ name: "ApartList", params: { dongCode: dongCode.value } });
  }
};

const onSearchByDongCodeClick = (dongCode) => {
  search.value = "";
  router.push({ name: "ApartList", params: { dongCode: dongCode } }, true);
};
</script>

<template>
  <div class="container-fluid" id="right-bar">
    <div class="search-select-wrap item">
      <div class="search-input-liner">
        <div class="input-wrap">
          <input
            type="text"
            placeholder="지역, 아파트 검색"
            :value="search"
            @input="handleSearchInput"
            @keydown.tab="KeydownTab" />
        </div>
        <div class="btn-search-wrap">
          <button class="btn-search" @click="onSearchByDongCode"></button>
        </div>
      </div>
      <div id="star-link" style="text-align: right; margin-top: 20px">
        <RouterLink :to="{ name: 'StarredArea', params: { loginId: authStore.loginId } }"
          ><h7>관심 지역</h7></RouterLink
        >
      </div>
    </div>
    <div class="list-detail-wrap item">
      <ApartRightUnder />
    </div>
    <div v-show="search.length !== 0" id="apart-search-list-wrap">
      <div v-for="value in searchList" id="apart-search-item">
        <h3 @click="onSearchByDongCodeClick(value.dongCode)">
          {{ value.sidoName + " " + value.gugunName + " " + value.dongName }}
        </h3>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "./css/right.css";
</style>
