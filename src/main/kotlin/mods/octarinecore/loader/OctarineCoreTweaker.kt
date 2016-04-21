package mods.octarinecore.loader

import net.minecraft.launchwrapper.ITweaker
import net.minecraft.launchwrapper.LaunchClassLoader
import java.io.File

class OctarineCoreTweaker : ITweaker {
    override fun acceptOptions(args: MutableList<String>?, gameDir: File?, assetsDir: File?, profile: String?) { }
    override fun getLaunchArguments(): Array<out String>? = Array(0) {""}
    override fun getLaunchTarget() = null
    override fun injectIntoClassLoader(classLoader: LaunchClassLoader) {
        classLoader.addTransformerExclusion("kotlin")
        classLoader.addTransformerExclusion("mods.octarinecore.kotlin")
        classLoader.addTransformerExclusion("mods.octarinecore.metaprog")
    }
}