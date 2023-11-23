<script setup>
import { ref, onMounted, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/authStore";
import { useApartStore } from "@/stores/apartStore";

const route = useRoute();
const router = useRouter();
const apartStore = useApartStore();
const authStore = useAuthStore();

const getStarredArea = (loginId) => {
  apartStore.fetchStarredArea(loginId);
};

// 초기 로딩 시와 라우트 변경 시 데이터 호출
const loadData = () => {
  getStarredArea(route.params.loginId);
};

onMounted(() => {
  // 초기 로딩 시 데이터 호출
  if (authStore.loginId === "not") {
    console.log("로그인 안함");
    alert("먼저 로그인을 해주세요");
    router.push({ name: "LoginView" });
  } else {
    console.log("로그인 함");
    console.log(authStore.loginId);
    loadData();
  }
});
</script>

<template>
  <div v-for="area in apartStore.areaList" class="starred-area-wrap">
    <router-link
      :to="{ name: 'ApartList', params: { dongCode: area[2] } }"
      style="text-decoration: none; color: inherit">
      <h2>
        {{ area[0] }}
      </h2>
      {{ area[1] }}
    </router-link>
  </div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap");
.starred-area-wrap {
  font-family: "Noto Sans KR", sans-serif;
  border: 1px solid #708090;
  overflow: hidden;
  width: 100%;
}
</style>
