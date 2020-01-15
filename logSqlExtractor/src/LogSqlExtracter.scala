import java.io.{BufferedReader, File, FileReader}
import java.nio.file.Path
import java.util

import com.asiainfo.ExtracterUtil
import com.asiainfo.log.AppLog
import main.com.asiainfo.CommonInterface.log.LogApproach
import main.com.asiainfo.CommonInterface.mongo.MongosLink
import main.com.asiainfo.CommonInterface.util.CommonUtil
import main.com.asiainfo.CommonInterface.xml.XmlInstance

object LogSqlExtracter {

  def main(args: Array[String]) : Unit = {
    //check input args:
    if (args.length < 2) {
      System.out.println("error input the log4j xml path.")
      return
    } else {
      XmlInstance.path = args(0)
      LogApproach.init(args(0), args(1))
    }

    AppLog.logger.info("###LogSqlExtracter running.")

    if (XmlInstance.getInstance() == null) {
      AppLog.logger.error("xml serialize failed:" + args(0))
      return
    }

    val logPath = XmlInstance.getInstance.readCommonValue("LogPath")
    if (logPath == null) {
      AppLog.logger.error("Need to fill in the path to log file")
      System.exit(-1)
    }

    try {
      ExtracterUtil.extract(logPath)
    } catch {
      case e: Exception => {
        e.printStackTrace()
      }
    }
  }





}
