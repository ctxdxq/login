<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="user"
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
        <template #title>
          <span>系统管理</span>
        </template>
          <el-menu-item index="user">用户管理</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <span>应用管理</span>
      </el-menu-item>
      <el-menu-item index="3">
        <span>知识库管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <span>提示词模板管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <span>大语言模型管理</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>

export default {
  name: "Aside",
}
</script>

<style scoped>

</style>