<script setup>
import TabView from "../menu/TabView.vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthStore } from "@/stores/authStore";

const router = useRouter();
const authStore = useAuthStore();

const onLogout = () => {
  alert("로그아웃되었습니다.");
  authStore.fetchLogout();
  router.push({ name: "MainView" });
};
</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light" id="pjt-nav">
    <div class="container-fluid" id="pjt-nav-container">
      <RouterLink :to="{ name: 'MainView' }">
        <img
          id="pjt-logo"
          src="@/assets/img/logo.png"
          alt=""
          width="120"
          height="100"
        />
      </RouterLink>

      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <RouterLink
            :to="{ name: 'ApartView' }"
            style="text-decoration: none; color: inherit"
          >
            <TabView class="tab" tab-name="매물조회" />
          </RouterLink>
          <RouterLink
            :to="{ name: 'CommunityView' }"
            style="text-decoration: none; color: inherit"
          >
            <TabView class="tab" tab-name="커뮤니티" />
          </RouterLink>
          <RouterLink
            :to="{ name: 'RentalView' }"
            style="text-decoration: none; color: inherit"
          >
            <TabView class="tab" tab-name="단기양도" />
          </RouterLink>
        </ul>
      </div>

      <div
        class="collapse navbar-collapse"
        id="navbarSupportedContent"
        v-if="authStore.loginId === 'not'"
      >
        <div class="ms-auto"></div>
        <ul class="navbar-nav mb-2 mb-lg-0">
          <li class="nav-item">
            <h5>
              <RouterLink
                :to="{ name: 'JoinView' }"
                class="nav-link"
                style="text-decoration: none; color: inherit"
                >회원가입</RouterLink
              >
            </h5>
          </li>
          <li class="nav-item">
            <h5>
              <RouterLink
                :to="{ name: 'LoginView' }"
                class="nav-link"
                style="text-decoration: none; color: inherit"
                >로그인</RouterLink
              >
            </h5>
          </li>
        </ul>
      </div>
      <div v-else>
        <div class="ms-auto"></div>
        <ul class="navbar-nav mb-2 mb-lg-0">
          <li class="nav-item" v-if="authStore.loginId === 'admin'">
            <h5>
              <RouterLink
                :to="{ name: 'AdminView' }"
                class="nav-link"
                style="text-decoration: none; color: inherit"
                >관리페이지</RouterLink
              >
            </h5>
          </li>
          <li class="nav-item" v-else>
            <h5>
              <RouterLink
                :to="{ name: 'JoinView' }"
                class="nav-link"
                style="text-decoration: none; color: inherit"
                >마이페이지</RouterLink
              >
            </h5>
          </li>
          <li class="nav-item">
            <div class="nav-link"><h5 @click="onLogout">로그아웃</h5></div>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped>
#pjt-logo {
  margin-right: 40px;
}
.tab {
  margin-left: 40px;
  margin: 40px;
}

#pjt-nav {
  /* position: absolute; */
  background-color: white;
  padding-top: 1px;
  padding-bottom: 1px;
  height: 110px;
  width: 100%;
}

#pjt-nav-container {
  margin-left: 60px;
  margin-right: 80px;
}

.nav-link {
  margin: 10px;
}
</style>
