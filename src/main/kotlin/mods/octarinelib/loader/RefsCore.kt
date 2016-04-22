package mods.octarinelib.loader

import mods.octarinelib.metaprog.ClassRef
import mods.octarinelib.metaprog.FieldRef
import mods.octarinelib.metaprog.MethodRef
import net.minecraftforge.fml.relauncher.FMLInjectionData

/** Singleton object holding references to foreign code elements. */
object RefsCore {
    val mcVersion = FMLInjectionData.data()[4].toString()

    // Java
    val Map = ClassRef("java.util.Map")
    val List = ClassRef("java.util.List")
    val Random = ClassRef("java.util.Random")

    // Minecraft
    val IBlockAccess = ClassRef("net.minecraft.world.IBlockAccess", "ahx")
    val IBlockState = ClassRef("net.minecraft.block.state.IBlockState", "arc")
    val BlockStateBase = ClassRef("net.minecraft.block.state.BlockStateBase", "ara")
    val BlockPos = ClassRef("net.minecraft.util.math.BlockPos", "cj")
    val MutableBlockPos = ClassRef("net.minecraft.util.math.BlockPos\$MutableBlockPos", "cj\$a")
    val BlockRenderLayer = ClassRef("net.minecraft.util.BlockRenderLayer", "ahm")
    val EnumFacing = ClassRef("net.minecraft.util.EnumFacing", "cq")

    val World = ClassRef("net.minecraft.world.World", "aht")
    val WorldClient = ClassRef("net.minecraft.client.multiplayer.WorldClient", "bku")
    val showBarrierParticles = MethodRef(WorldClient, "showBarrierParticles", "func_184153_a", "a", ClassRef.Companion.void, ClassRef.Companion.int, ClassRef.Companion.int, ClassRef.Companion.int, ClassRef.Companion.int, Random, ClassRef.Companion.boolean, MutableBlockPos)

    val Block = ClassRef("net.minecraft.block.Block", "ajt")
    val StateImplementation = ClassRef("net.minecraft.block.state.BlockStateContainer\$StateImplementation", "ard\$a")
    val canRenderInLayer = MethodRef(Block, "canRenderInLayer", ClassRef.Companion.boolean, IBlockState, BlockRenderLayer)
    val getAmbientOcclusionLightValue = MethodRef(StateImplementation, "getAmbientOcclusionLightValue", "func_185892_j", "j", ClassRef.Companion.float)
    val useNeighborBrightness = MethodRef(StateImplementation, "useNeighborBrightness", "func_185916_f", "f", ClassRef.Companion.boolean)
    val doesSideBlockRendering = MethodRef(StateImplementation, "doesSideBlockRendering", ClassRef.Companion.boolean, IBlockAccess, BlockPos, EnumFacing)
    val isOpaqueCube = MethodRef(StateImplementation, "isOpaqueCube", "", "p", ClassRef.Companion.boolean)
    val randomDisplayTick = MethodRef(Block, "randomDisplayTick", "func_180655_c", "a", ClassRef.Companion.void, IBlockState, World, BlockPos, Random)

    val BlockModelRenderer = ClassRef("net.minecraft.client.renderer.BlockModelRenderer", "boe")
    val AmbientOcclusionFace = ClassRef("net.minecraft.client.renderer.BlockModelRenderer\$AmbientOcclusionFace", "boe\$b")
    val ChunkCompileTaskGenerator = ClassRef("net.minecraft.client.renderer.chunk.ChunkCompileTaskGenerator", "bpz")
    val VertexBuffer = ClassRef("net.minecraft.client.renderer.VertexBuffer", "bmz")
    val AOF_constructor = MethodRef(AmbientOcclusionFace, "<init>", ClassRef.Companion.void, BlockModelRenderer)

    val RenderChunk = ClassRef("net.minecraft.client.renderer.chunk.RenderChunk", "bqf")
    val rebuildChunk = MethodRef(RenderChunk, "rebuildChunk", "func_178581_b", "b", ClassRef.Companion.void, ClassRef.Companion.float, ClassRef.Companion.float, ClassRef.Companion.float, ChunkCompileTaskGenerator)

    val BlockRendererDispatcher = ClassRef("net.minecraft.client.renderer.BlockRendererDispatcher", "boc")
    val renderBlock = MethodRef(BlockRendererDispatcher, "renderBlock", "func_175018_a", "a", ClassRef.Companion.boolean, IBlockState, BlockPos, IBlockAccess, VertexBuffer)

    val TextureAtlasSprite = ClassRef("net.minecraft.client.renderer.texture.TextureAtlasSprite", "bvh")

    val IRegistry = ClassRef("net.minecraft.util.registry.IRegistry", "db")
    val ModelLoader = ClassRef("net.minecraftforge.client.model.ModelLoader")
    val stateModels = FieldRef(ModelLoader, "stateModels", Map)
    val setupModelRegistry = MethodRef(ModelLoader, "setupModelRegistry", "func_177570_a", "a", IRegistry)

    val IModel = ClassRef("net.minecraftforge.client.model.IModel")
    val ModelBlock = ClassRef("net.minecraft.client.renderer.block.model.ModelBlock", "bok")
    val ModelResourceLocation = ClassRef("net.minecraft.client.renderer.block.model.ModelResourceLocation", "bxt")
    val VanillaModelWrapper = ClassRef("net.minecraftforge.client.model.ModelLoader\$VanillaModelWrapper")
    val model_VMW = FieldRef(VanillaModelWrapper, "model", ModelBlock)
    val location_VMW = FieldRef(VanillaModelWrapper, "location", ModelBlock)
    val WeightedPartWrapper = ClassRef("net.minecraftforge.client.model.ModelLoader\$WeightedPartWrapper")
    val model_WPW = FieldRef(WeightedPartWrapper, "model", IModel)
    val WeightedRandomModel = ClassRef("net.minecraftforge.client.model.ModelLoader\$WeightedRandomModel")
    val models_WRM = FieldRef(WeightedRandomModel, "models", List)

    // Better Foliage
    val BetterFoliageHooks = ClassRef("mods.betterfoliage.client.Hooks")
    val getAmbientOcclusionLightValueOverride = MethodRef(BetterFoliageHooks, "getAmbientOcclusionLightValueOverride", ClassRef.Companion.float, ClassRef.Companion.float, IBlockState)
    val useNeighborBrightnessOverride = MethodRef(BetterFoliageHooks, "getUseNeighborBrightnessOverride", ClassRef.Companion.boolean, ClassRef.Companion.boolean, IBlockState)
    val doesSideBlockRenderingOverride = MethodRef(BetterFoliageHooks, "doesSideBlockRenderingOverride", ClassRef.Companion.boolean, ClassRef.Companion.boolean, IBlockAccess, BlockPos, EnumFacing)
    val isOpaqueCubeOverride = MethodRef(BetterFoliageHooks, "isOpaqueCubeOverride", ClassRef.Companion.boolean, ClassRef.Companion.boolean, IBlockState)
    val onRandomDisplayTick = MethodRef(BetterFoliageHooks, "onRandomDisplayTick", ClassRef.Companion.void, World, IBlockState, BlockPos)
    val onAfterLoadModelDefinitions = MethodRef(BetterFoliageHooks, "onAfterLoadModelDefinitions", ClassRef.Companion.void, ModelLoader)
    val renderWorldBlock = MethodRef(BetterFoliageHooks, "renderWorldBlock", ClassRef.Companion.boolean, BlockRendererDispatcher, IBlockState, BlockPos, IBlockAccess, VertexBuffer, BlockRenderLayer)
    val canRenderBlockInLayer = MethodRef(BetterFoliageHooks, "canRenderBlockInLayer", ClassRef.Companion.boolean, Block, IBlockState, BlockRenderLayer)

    // Optifine
    val OptifineClassTransformer = ClassRef("optifine.OptiFineClassTransformer")

    val RenderEnv = ClassRef("RenderEnv")
    val RenderEnv_reset = MethodRef(RenderEnv, "reset", ClassRef.Companion.void, IBlockAccess, IBlockState, BlockPos)
    val ConnectedTextures = ClassRef("ConnectedTextures")
    val getConnectedTexture = MethodRef(ConnectedTextures, "getConnectedTextureMultiPass", TextureAtlasSprite, IBlockAccess, IBlockState, BlockPos, EnumFacing, TextureAtlasSprite, RenderEnv)
    val CTblockProperties = FieldRef(ConnectedTextures, "blockProperties", null)
    val CTtileProperties = FieldRef(ConnectedTextures, "tileProperties", null)

    val ConnectedProperties = ClassRef("ConnectedProperties")
    val CPtileIcons = FieldRef(ConnectedProperties, "tileIcons", null)
    val CPmatchesBlock = MethodRef(ConnectedProperties, "matchesBlock", ClassRef.Companion.boolean, BlockStateBase)
    val CPmatchesIcon = MethodRef(ConnectedProperties, "matchesIcon", ClassRef.Companion.boolean, TextureAtlasSprite)

    // ShadersMod
    val SVertexBuilder = ClassRef("shadersmod.client.SVertexBuilder")
    val sVertexBuilder = FieldRef(VertexBuffer, "sVertexBuilder", SVertexBuilder)
    val pushEntity_state = MethodRef(SVertexBuilder, "pushEntity", ClassRef.Companion.void, IBlockState, BlockPos, IBlockAccess, VertexBuffer)
    val pushEntity_num = MethodRef(SVertexBuilder, "pushEntity", ClassRef.Companion.void, ClassRef.Companion.long)
    val popEntity = MethodRef(SVertexBuilder, "popEntity", ClassRef.Companion.void)

    val ShadersModIntegration = ClassRef("mods.betterfoliage.client.integration.ShadersModIntegration")
    val getBlockIdOverride = MethodRef(ShadersModIntegration, "getBlockIdOverride", ClassRef.Companion.long, ClassRef.Companion.long, IBlockState)
}