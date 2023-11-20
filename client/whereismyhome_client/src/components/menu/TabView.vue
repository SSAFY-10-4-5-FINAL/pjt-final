<script setup>
const props = defineProps({ tabName: String });

const tabName = props.tabName;
</script>

<template>
  <li class="nav-item">
    <h2>
      <a class="nav-link" aria-current="page" href="#">{{ tabName }}</a>
    </h2>
  </li>
</template>

<style scoped></style>
