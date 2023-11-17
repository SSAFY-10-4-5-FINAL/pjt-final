<script setup></script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light" id="pjt-nav">
    <div class="container-fluid" id="pjt-nav-container">
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
          <TabView class="tab" tab-name="매물조회" />
          <TabView class="tab" tab-name="커뮤니티" />
          <TabView class="tab" tab-name="단기양도" />
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped></style>
