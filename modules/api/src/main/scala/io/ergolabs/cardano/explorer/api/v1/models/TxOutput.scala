package io.ergolabs.cardano.explorer.api.v1.models

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import io.ergolabs.cardano.explorer.api.v1.instances._
import io.ergolabs.cardano.explorer.core.types.{Addr, BlockHash, Hash32, OutRef}
import sttp.tapir.Schema

@derive(encoder, decoder)
final case class TxOutput(
  ref: OutRef,
  blockHash: BlockHash,
  index: Int,
  addr: Addr,
  value: BigInt,
  jsValue: String,
  dataHash: Option[Hash32],
  assets: List[OutAsset]
)

object TxOutput {
  implicit def schema: Schema[TxOutput] = Schema.derived
}
