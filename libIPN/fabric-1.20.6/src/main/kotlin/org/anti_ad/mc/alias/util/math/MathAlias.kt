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

package org.anti_ad.mc.alias.util.math

import net.minecraft.util.math.AffineTransformation
import net.minecraft.util.math.AffineTransformations
import net.minecraft.util.math.AxisCycleDirection
import net.minecraft.util.math.AxisTransformation
import net.minecraft.util.math.BlockBox
import net.minecraft.util.math.BlockPointer
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Boxes
import net.minecraft.util.math.ChunkPos
import net.minecraft.util.math.ChunkSectionPos
import net.minecraft.util.math.ColorHelper
import net.minecraft.util.math.ColumnPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.DirectionTransformation
import net.minecraft.util.math.Divider
import net.minecraft.util.math.EightWayDirection
import net.minecraft.util.math.EulerAngle
import net.minecraft.util.math.GivensPair
import net.minecraft.util.math.GlobalPos
import net.minecraft.util.math.GravityField
import net.minecraft.util.math.ImmutableBlockBox
import net.minecraft.util.math.LongJumpUtil
import net.minecraft.util.math.MathConstants
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.MatrixUtil
import net.minecraft.util.math.Position
import net.minecraft.util.math.Quantiles
import net.minecraft.util.math.RotationAxis
import net.minecraft.util.math.RotationCalculator
import net.minecraft.util.math.RotationPropertyHelper
/*
import net.minecraft.util.math.Smoother
*/
import net.minecraft.util.math.Spline
import net.minecraft.util.math.Vec2f
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import net.minecraft.util.math.VerticalSurfaceType
import net.minecraft.util.math.WordPackedArray


typealias AffineTransformation = AffineTransformation
typealias AffineTransformations = AffineTransformations
typealias AxisCycleDirection = AxisCycleDirection
typealias AxisTransformation = AxisTransformation
typealias BlockBox = BlockBox
typealias BlockPointer = BlockPointer
typealias BlockPos = BlockPos
typealias Box = Box
typealias Boxes = Boxes
typealias ChunkPos = ChunkPos
typealias ChunkSectionPos = ChunkSectionPos
typealias ColorHelper = ColorHelper
typealias ColumnPos = ColumnPos
typealias Direction = Direction
typealias DirectionTransformation = DirectionTransformation
typealias Divider = Divider
typealias EightWayDirection = EightWayDirection
typealias EulerAngle = EulerAngle
typealias GivensPair = GivensPair
typealias GlobalPos = GlobalPos
typealias GravityField = GravityField
typealias ImmutableBlockBox = ImmutableBlockBox
typealias LongJumpUtil = LongJumpUtil
typealias MathConstants = MathConstants
typealias MathHelper = MathHelper
typealias MatrixUtil = MatrixUtil
typealias Position = Position
typealias Quantiles = Quantiles
typealias RotationAxis = RotationAxis
typealias RotationCalculator = RotationCalculator
typealias RotationPropertyHelper = RotationPropertyHelper
/*
typealias Smoother = Smoother
*/
typealias Spline<C, I> = Spline<C, I>
typealias Vec2f = Vec2f
typealias Vec3d = Vec3d
typealias Vec3i = Vec3i
typealias VerticalSurfaceType = VerticalSurfaceType
typealias WordPackedArray = WordPackedArray
