<script setup>
defineProps({ board: Object });
console.log("hihi");
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ board.articleNo }}</th>
    <td class="text-start">
      <router-link class="article-title link-dark">
        {{ board.subject }}
      </router-link>
    </td>
    <td>{{ board.userId }}</td>
    <td>{{ board.hit }}</td>
    <td>{{ board.registerTime }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
