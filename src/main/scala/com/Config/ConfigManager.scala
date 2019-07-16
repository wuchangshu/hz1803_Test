package com.Config

import java.util.Properties


object ConfigManager {
  private val prop = new Properties()
  // 通过类加载器方法来加载指定的配置文件
  try{
    val in_dws = ConfigManager.getClass.getClassLoader.getResourceAsStream("dwd_dws.properties")

    val in_basic = ConfigManager.getClass.getClassLoader.getResourceAsStream("basic.properties")

    val in_dm = ConfigManager.getClass.getClassLoader.getResourceAsStream("dws_dm.properties")
    prop.load(in_dws)
    prop.load(in_basic)
    prop.load(in_dm)
  }catch {
    case e:Exception=>e.printStackTrace()
  }
  /**
    * 获取指定Key的对应Value
    */
  def getProper(key:String):String={
    prop.getProperty(key)
  }
}