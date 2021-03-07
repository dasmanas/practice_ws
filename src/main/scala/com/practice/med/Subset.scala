package com.practice.med

object Subset {

  def main(args: Array[String]): Unit = {
    println(subsets(Array(1, 2, 3)))
  }

  def subsets(nums: Array[Int]): List[List[Int]] = {
    nums.foldLeft(List(List.empty[Int])) {
      (acc, num) => { acc ++ acc.map { f: List[Int] => f :+ num }
      }
    }
  }
}
