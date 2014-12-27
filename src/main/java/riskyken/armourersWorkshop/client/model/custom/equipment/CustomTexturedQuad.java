package riskyken.armourersWorkshop.client.model.custom.equipment;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.util.Vec3;
import riskyken.armourersWorkshop.client.abstraction.IRenderBuffer;

public class CustomTexturedQuad extends TexturedQuad {

    public CustomTexturedQuad(PositionTextureVertex[] p_i1153_1_,
            int p_i1153_2_, int p_i1153_3_, int p_i1153_4_, int p_i1153_5_,
            float p_i1153_6_, float p_i1153_7_) {
        super(p_i1153_1_, p_i1153_2_, p_i1153_3_, p_i1153_4_, p_i1153_5_, p_i1153_6_,
                p_i1153_7_);
    }
    
    public void draw(IRenderBuffer renderBuffer, float scale) {
        Vec3 vec3 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[0].vector3D);
        Vec3 vec31 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[2].vector3D);
        Vec3 vec32 = vec31.crossProduct(vec3).normalize();
        //renderBuffer.startDrawingQuads();

        renderBuffer.setNormal((float)vec32.xCoord, (float)vec32.yCoord, (float)vec32.zCoord);

        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positiontexturevertex = this.vertexPositions[i];
            renderBuffer.addVertex((double)((float)positiontexturevertex.vector3D.xCoord * scale), (double)((float)positiontexturevertex.vector3D.yCoord * scale), (double)((float)positiontexturevertex.vector3D.zCoord * scale));
        }

        //renderBuffer.draw();
    }

}
