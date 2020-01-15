package com.asiainfo.test

import java.util

import com.asiainfo.ExtracterUtil
import main.com.asiainfo.CommonInterface.log.LogApproach
import main.com.asiainfo.CommonInterface.util.CommonUtil
import org.junit.Test

class CommonTests {

  @Test
  def localTestInfo() ={
      LogApproach.init("LogSql", "E:\\mnt\\log4j2Windows_info.xml")
      //val log = "D:\\finance_local\\financemngt\\logs\\fjs.log"
      //val log ="C:\\Users\\admin\\Documents\\Tencent Files\\771412351\\FileRecv\\新包.1_"//"D:\\finance_local\\financemngt\\logs\\fjs.log"
      //val log ="C:\\Users\\admin\\Documents\\Tencent Files\\771412351\\FileRecv\\旧包.1_"//"D:\\finance_local\\financemngt\\logs\\fjs.log"
      //val log = "E:\\mnt\\log\\20190705.log"
      //val log = "D:\\temp\\ar_ejb1_535546486.635591630-32101102051577.txt"
//      val log ="D:\\temp\\logs\\ar.log"
//      val log = "D:\\reference\\ar\\deduct表不生成记录问题\\70000000062017101057210017.txt"
      //    val log ="D:\\temp\\logs\\ar_newConnect.log"
//    val log = "D:\\\\reference\\\\ar\\\\deduct表不生成记录问题\\\\70000000062017101057210019_n_预扣.txt"

      //val log = "E:\\mnt\\ims_ejb_535546484.635591622.1_"
      val log ="D:\\reference\\ar\\反悔分期\\ims_ejb4_535547690.635594278.1_"
      ExtracterUtil.extract(log)

  }

  @Test
  def localTestDebug()  ={
    LogApproach.init("LogSql", "E:\\mnt\\log4j2Windows_debug.xml")
    //val log ="D:\\finance_local\\financemngt\\logs\\fjs.log"
//    val log = "E:\\mnt\\ims_ejb_535546484.635591622.1_"
    val log ="D:\\reference\\ar\\deduct表不生成记录问题\\70000000062017101057210017.txt"


    ExtracterUtil.extract(log)

  }

  @Test
  def testSelectSqlBody() = {
    val line = "INFO [2019-05-06 10:50:30] Logger.java._log(190) - select t.* from FC.FC_ACCT_PERIOD t where t.BEGIN_DATE<=? and t.END_DATE>=? and t.TENANT_ID=? | [Tx20216209@tdk_fjs.fc@1]"
    //    var sqlBody = line.substring(   line.indexOf("update"))
    //    sqlBody = sqlBody.substring(0, sqlBody.indexOf(" | ["))
    var sqlBody = line.substring(   line.indexOf("select"), line.indexOf(" | ["))

    System.out.println(sqlBody)
    sqlBody = sqlBody.replace("?","%s")
    System.out.println(sqlBody)

    val paraCount = CommonUtil.countOfString(sqlBody,"%s")
    System.out.println(paraCount)

    val lineArray = new util.ArrayList[String]
    lineArray.add("(1)beginDate:    \t[2018-12-03 00:00:00.0]")
    lineArray.add("(2)endDate:      \t[2018-12-03 00:00:00.0]")
    lineArray.add("(3)tenantId:     \t[21]")

    val paraArray = new util.ArrayList[String]

    for ( i <- 0 until paraCount ){
      val paraLine = lineArray.get(i)
      val parameter = paraLine.substring( paraLine.indexOf("[") + 1, paraLine.indexOf("]") )
      System.out.println("obtained parameter===>" + parameter)
      paraArray.add(parameter)
    }

    val fullSql = formatSql(sqlBody, paraArray, paraCount)
    System.out.println(fullSql)
  }

  def formatSql(sqlBody:String,paraArray:util.ArrayList[String], paraCount:Int ):String ={
    if (paraCount < 1 || paraCount > 23) {
      sqlBody
    }
    paraCount match {
      case 1 => String.format(sqlBody,paraArray.get(0))
      case 2 => String.format(sqlBody,paraArray.get(0),paraArray.get(1) )
      case 3 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2) )
      case 4 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3) )
      case 5 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4) )
      case 6 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5) )
      case 7 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6) )
      case 8 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7) )
      case 9 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8) )
      case 10 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9) )
      case 11 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10) )
      case 12 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11) )
      case 13 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12) )
      case 14 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13) )
      case 15 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14) )
      case 16 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15) )
      case 17 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3) ,paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16))
      case 18 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17) )
      case 19 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17),paraArray.get(18) )
      case 20 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17),paraArray.get(18),paraArray.get(19) )
      case 21 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17),paraArray.get(18),paraArray.get(19),paraArray.get(20) )
      case 22 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17),paraArray.get(18),paraArray.get(19),paraArray.get(20),paraArray.get(21) )
      case 23 => String.format(sqlBody,paraArray.get(0),paraArray.get(1),paraArray.get(2),paraArray.get(3),paraArray.get(4),paraArray.get(5),paraArray.get(6),paraArray.get(7),paraArray.get(8),paraArray.get(9),paraArray.get(10),paraArray.get(11),paraArray.get(12),paraArray.get(13),paraArray.get(14),paraArray.get(15),paraArray.get(16),paraArray.get(17),paraArray.get(18),paraArray.get(19),paraArray.get(20),paraArray.get(21),paraArray.get(22) )

    }

  }

  @Test
  def testUpdateSqlBody() = {
    val line = " INFO [2019-05-06 10:50:30] Logger.java._log(190) - update FJ.FJ_BILL_ADJUSTMENT_21_201812 set DEAL_DATE = ?, DEAL_STS = ?, TENANT_ID = ? where ID=? | [Batch07420530@tdk_fjs.fc@1]"
//    var sqlBody = line.substring(   line.indexOf("update"))
//    sqlBody = sqlBody.substring(0, sqlBody.indexOf(" | ["))
    var sqlBody = line.substring(   line.indexOf("update"), line.indexOf(" | ["))

    System.out.println(sqlBody)
    val paraCount = CommonUtil.countOfChar(sqlBody,'?')
    System.out.println(paraCount)

    val paraLine = "(1)beginDate:    \t[2018-12-03 00:00:00.0]"
    val parameter = paraLine.substring( paraLine.indexOf("[") + 1,paraLine.indexOf("]") )
    System.out.println(parameter)




  }

  @Test
  def generateFormatSql()={
    val count = 100
    //case 2 => String.format(sqlBody,paraArray.get(0),paraArray.get(1) )
    val resultStr = new StringBuffer()
    for ( i <- 0 until count ) {
      resultStr.append("case " + i + " => String.format( sqlBody")
      for( j <- 0 until i) {
        resultStr.append(", paraArray.get(" + j + ")")
      }
      resultStr.append(" )\n")
    }
    System.out.println( resultStr)
  }

//
//  @Test
//  def testconcatSql()={
//    val sql = String.format("DELETE FROM %2s where AIMDB_extern_flag<> %1d and tenant_id = %d limit %d", 0, "fj_abc_0_21_201907", 21,1000);
//    System.out.println(sql);
//  }
}
