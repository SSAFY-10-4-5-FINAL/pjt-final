<script setup>
import TabView from "../menu/TabView.vue";
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

          <TabView class="tab" tab-name="커뮤니티" />
          <TabView class="tab" tab-name="단기양도" />
        </ul>
      </div>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="ms-auto"></div>
        <ul class="navbar-nav mb-2 mb-lg-0">
          <li class="nav-item">
            <h5>
              <a class="nav-link" aria-current="page" href="#">회원가입</a>
            </h5>
          </li>
          <li class="nav-item">
            <h5>
              <a class="nav-link" aria-current="page" href="#">로그인</a>
            </h5>
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
  border-bottom: 1px solid black;
  padding-top: 1px;
  padding-bottom: 1px;
  height: 110px;
}

#pjt-nav-container {
  margin-left: 60px;
  margin-right: 80px;
}

.nav-link {
  margin: 10px;
}
</style>
