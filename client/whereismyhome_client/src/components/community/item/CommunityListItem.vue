<script setup>
// Data
const props = defineProps({ index: Number, board: Object });
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ index + 1 }}</th>
    <td class="text-start">
      <router-link
        :to="{
          name: 'CommunityDetail',
          params: { articleNo: board.articleNo },
        }"
        class="article-title link-dark">
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
