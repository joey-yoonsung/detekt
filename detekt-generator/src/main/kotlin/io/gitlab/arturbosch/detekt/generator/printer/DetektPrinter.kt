package io.gitlab.arturbosch.detekt.generator.printer

import io.gitlab.arturbosch.detekt.generator.out.MarkdownWriter
import io.gitlab.arturbosch.detekt.generator.out.YamlWriter

class DetektPrinter {
	private val markdownWriter = MarkdownWriter()
	private val yamlWriter = YamlWriter()

	fun print(pages: List<RuleSetPage>) {
		pages.forEach {
			val pageContent = RuleSetPagePrinter.print(it)
			markdownWriter.write(it.ruleSet.name, pageContent)
		}

		val defaultConfig = ConfigPrinter.print(pages)
		yamlWriter.write("default-detekt-config", defaultConfig)
	}

}
