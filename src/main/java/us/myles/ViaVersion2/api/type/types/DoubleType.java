package us.myles.ViaVersion2.api.type.types;

import io.netty.buffer.ByteBuf;
import us.myles.ViaVersion2.api.type.Type;
import us.myles.ViaVersion2.api.type.TypeConverter;

public class DoubleType extends Type<Double> implements TypeConverter<Double>{
    public DoubleType() {
        super(Double.class);
    }

    @Override
    public Double read(ByteBuf buffer) {
        return buffer.readDouble();
    }

    @Override
    public void write(ByteBuf buffer, Double object) {
        buffer.writeDouble(object);
    }

    @Override
    public Double from(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        if(o instanceof Boolean){
            return ((Boolean)o) == true ? 1D : 0D;
        }
        return (Double) o;
    }
}
