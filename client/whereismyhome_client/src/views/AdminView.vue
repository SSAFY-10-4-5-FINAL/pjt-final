<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();
</script>

<template>
  <div class="container-fluid">
    <div class="user-list-wrap">
      <RouterView />
    </div>
  </div>
</template>

<style scoped>
.container-fluid {
  display: flex;
  justify-content: center;
  align-items: center;
  border-top: 1px solid #4d5964;
  padding: 0px;
  height: 90vh;
}
.user-list-wrap {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  margin-top: 50px;
  padding: 100px;
  width: 87%;
  height: 100%;
}
</style>
