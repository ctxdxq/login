<template>
  <div style="width: 100%; height: 100vh; background-color: cornflowerblue; overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <div style="color: #cccccc; font-size: 30px; text-align: center; padding: 30px 0">欢迎登录</div>
      <el-form :model="form" label-width="auto" style="max-width: 600px" size="normal" :rules="rules" ref="form">
        <el-form-item prop="username">
          <el-input v-model="form.name" :prefix-icon="User" placeholder="请输入账号"/>
<!--          <el-button @click="test">测试</el-button>-->
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" :prefix-icon="Lock" placeholder="请输入密码" show-password/>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="login">登 录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="register">注 册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {Lock, User} from "@element-plus/icons";
import request from "@/utils/request";

export default {
  name: "Login",
  computed: {
    Lock() {
      return Lock
    },
    User() {
      return User
    }
  },
  methods: {
    login() {
      console.log(this.form);
      request.post("/user/login", this.form).then(res => {
        if(res.code === 0){
          this.$message({
            type: "success",
            message: "登录成功"
          })
          this.$router.push("/home")
        } else {
          this.$message({
            type: "error",
            message: "登录失败"
          })
        }
        // console.log(res);
      })
    },
    // test(){
    //   request.get("/messagelist").then(res => {
    //     console.log(res);
    //   })
    // },
    register() {
      this.$router.push("/register")
    },
  },
  data() {
    return{
      form: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
      }
    }
  }
}
</script>

<style scoped>

</style>