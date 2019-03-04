import scala.io.Source

object SpreadSheetChecksum extends App {

  type Sheet = Seq[Seq[Long]]

  def readSpreadsheet(file: String): Sheet =
    Source.fromFile(file).getLines()
      .map {
        _.split("\\s+").map(_.toLong).toSeq
      }.toSeq

  def checksum(sheet: Sheet): Long = sheet.map(row => row.max - row.min).sum

  val fileName = "spreadsheet.tsv"

  println(checksum(readSpreadsheet(fileName)))
}
