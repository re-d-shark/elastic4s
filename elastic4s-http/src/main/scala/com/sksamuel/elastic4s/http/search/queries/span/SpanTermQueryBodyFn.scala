package com.sksamuel.elastic4s.http.search.queries.span

import com.sksamuel.elastic4s.searches.queries.span.SpanTermQueryDefinition
import org.elasticsearch.common.xcontent.{XContentBuilder, XContentFactory}

object SpanTermQueryBodyFn {
  def apply(q: SpanTermQueryDefinition): XContentBuilder = {
    val builder = XContentFactory.jsonBuilder()
    builder.startObject()
    builder.startObject("span_term")
    builder.field(q.field, q.value)
    q.boost.foreach(builder.field("boost", _))
    q.queryName.foreach(builder.field("_name", _))
    builder.endObject()
    builder.endObject()
  }
}
