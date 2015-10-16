/**
 * (C) Copyright IBM Corp. 2015, 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.powertrack

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SQLContext, DataFrame}

object AnalysisFunction
{
	def registerAnalysisFunctions() = 
	{
		ApplicationContext.sqlContext.udf.register("stringTokenizer", (text: String) => stringTokenizer(text))
	}

	def stringTokenizer(text: String): Array[String] = 
	{
		return Twokenize.tokenize(text.toLowerCase().trim()).toArray
	}
}