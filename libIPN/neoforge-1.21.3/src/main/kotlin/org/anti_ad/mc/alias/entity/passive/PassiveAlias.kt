/*
 * Inventory Profiles Next
 *
 *   Copyright (c) 2024 Plamen K. Kosseff <p.kosseff@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anti_ad.mc.alias.entity.passive

/*
import net.minecraft.entity.passive.AbstractDonkeyEntity
import net.minecraft.entity.passive.AbstractHorseEntity
import net.minecraft.entity.passive.AllayBrain
import net.minecraft.entity.passive.AllayEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.ArmadilloBrain
import net.minecraft.entity.passive.ArmadilloEntity
import net.minecraft.entity.passive.AxolotlBrain
import net.minecraft.entity.passive.AxolotlEntity
import net.minecraft.entity.passive.BatEntity
import net.minecraft.entity.passive.BeeEntity
import net.minecraft.entity.passive.CamelBrain
import net.minecraft.entity.passive.CamelEntity
import net.minecraft.entity.passive.CatEntity
import net.minecraft.entity.passive.CatVariant
import net.minecraft.entity.passive.ChickenEntity
import net.minecraft.entity.passive.CodEntity
import net.minecraft.entity.passive.CowEntity
import net.minecraft.entity.passive.Cracks
import net.minecraft.entity.passive.DolphinEntity
import net.minecraft.entity.passive.DonkeyEntity
import net.minecraft.entity.passive.FishEntity
import net.minecraft.entity.passive.FoxEntity
import net.minecraft.entity.passive.FrogBrain
import net.minecraft.entity.passive.FrogEntity
import net.minecraft.entity.passive.FrogVariant
import net.minecraft.entity.passive.GlowSquidEntity
import net.minecraft.entity.passive.GoatBrain
import net.minecraft.entity.passive.GoatEntity
import net.minecraft.entity.passive.GolemEntity
import net.minecraft.entity.passive.HorseColor
import net.minecraft.entity.passive.HorseEntity
import net.minecraft.entity.passive.HorseMarking
import net.minecraft.entity.passive.IronGolemEntity
import net.minecraft.entity.passive.LlamaEntity
import net.minecraft.entity.passive.MerchantEntity
import net.minecraft.entity.passive.MooshroomEntity
import net.minecraft.entity.passive.MuleEntity
import net.minecraft.entity.passive.OcelotEntity
import net.minecraft.entity.passive.PandaEntity
import net.minecraft.entity.passive.ParrotEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.passive.PigEntity
import net.minecraft.entity.passive.PolarBearEntity
import net.minecraft.entity.passive.PufferfishEntity
import net.minecraft.entity.passive.RabbitEntity
import net.minecraft.entity.passive.SalmonEntity
import net.minecraft.entity.passive.SchoolingFishEntity
import net.minecraft.entity.passive.SheepEntity
import net.minecraft.entity.passive.SnifferBrain
import net.minecraft.entity.passive.SnifferEntity
import net.minecraft.entity.passive.SnowGolemEntity
import net.minecraft.entity.passive.SquidEntity
import net.minecraft.entity.passive.StriderEntity
import net.minecraft.entity.passive.TadpoleBrain
import net.minecraft.entity.passive.TadpoleEntity
import net.minecraft.entity.passive.TameableEntity
import net.minecraft.entity.passive.TameableShoulderEntity
import net.minecraft.entity.passive.TraderLlamaEntity
import net.minecraft.entity.passive.TropicalFishEntity
import net.minecraft.entity.passive.TurtleEntity
*/
import net.minecraft.world.entity.npc.AbstractVillager
import net.minecraft.world.entity.npc.Villager
import net.minecraft.world.entity.npc.WanderingTrader

/*
import net.minecraft.entity.passive.WanderingTraderEntity
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.entity.passive.WolfVariant
import net.minecraft.entity.passive.WolfVariants
*/


/*
typealias AbstractDonkeyEntity = AbstractDonkeyEntity
typealias AbstractHorseEntity = AbstractHorseEntity
typealias AllayBrain = AllayBrain
typealias AllayEntity = AllayEntity
typealias AnimalEntity = AnimalEntity
typealias ArmadilloBrain = ArmadilloBrain
typealias ArmadilloEntity = ArmadilloEntity
typealias AxolotlBrain = AxolotlBrain
typealias AxolotlEntity = AxolotlEntity
typealias BatEntity = BatEntity
typealias BeeEntity = BeeEntity
typealias CamelBrain = CamelBrain
typealias CamelEntity = CamelEntity
typealias CatEntity = CatEntity
typealias CatVariant = CatVariant
typealias ChickenEntity = ChickenEntity
typealias CodEntity = CodEntity
typealias CowEntity = CowEntity
typealias Cracks = Cracks
typealias DolphinEntity = DolphinEntity
typealias DonkeyEntity = DonkeyEntity
typealias FishEntity = FishEntity
typealias FoxEntity = FoxEntity
typealias FrogBrain = FrogBrain
typealias FrogEntity = FrogEntity
typealias FrogVariant = FrogVariant
typealias GlowSquidEntity = GlowSquidEntity
typealias GoatBrain = GoatBrain
typealias GoatEntity = GoatEntity
typealias GolemEntity = GolemEntity
typealias HorseColor = HorseColor
typealias HorseEntity = HorseEntity
typealias HorseMarking = HorseMarking
typealias IronGolemEntity = IronGolemEntity
typealias LlamaEntity = LlamaEntity
*/
typealias MerchantEntity = AbstractVillager
/*
typealias MooshroomEntity = MooshroomEntity
typealias MuleEntity = MuleEntity
typealias OcelotEntity = OcelotEntity
typealias PandaEntity = PandaEntity
typealias ParrotEntity = ParrotEntity
typealias PassiveEntity = PassiveEntity
typealias PigEntity = PigEntity
typealias PolarBearEntity = PolarBearEntity
typealias PufferfishEntity = PufferfishEntity
typealias RabbitEntity = RabbitEntity
typealias SalmonEntity = SalmonEntity
typealias SchoolingFishEntity = SchoolingFishEntity
typealias SheepEntity = SheepEntity
typealias SnifferBrain = SnifferBrain
typealias SnifferEntity = SnifferEntity
typealias SnowGolemEntity = SnowGolemEntity
typealias SquidEntity = SquidEntity
typealias StriderEntity = StriderEntity
typealias TadpoleBrain = TadpoleBrain
typealias TadpoleEntity = TadpoleEntity
typealias TameableEntity = TameableEntity
typealias TameableShoulderEntity = TameableShoulderEntity
typealias TraderLlamaEntity = TraderLlamaEntity
typealias TropicalFishEntity = TropicalFishEntity
typealias TurtleEntity = TurtleEntity
*/
typealias VillagerEntity = Villager
typealias WanderingTraderEntity = WanderingTrader
/*
typealias WolfEntity = WolfEntity
typealias WolfVariant = WolfVariant
typealias WolfVariants = WolfVariants
*/
