package me.bryangaming.common;

import me.fixeddev.commandflow.CommandContext;
import me.fixeddev.commandflow.annotated.part.PartFactory;
import me.fixeddev.commandflow.exception.ArgumentParseException;
import me.fixeddev.commandflow.part.CommandPart;
import me.fixeddev.commandflow.stack.ArgumentStack;
import net.kyori.text.TranslatableComponent;

import java.lang.annotation.Annotation;
import java.util.List;

// By Yushu
public class CommonSenderFactory implements PartFactory {

    private final Class<?> senderClass;
    private final Class<?> playerClass;
    private final String senderNamespace;

    public CommonSenderFactory(
            Class<?> senderClass,
            Class<?> playerClass,
            String senderNamespace) {
        this.senderClass = senderClass;
        this.playerClass = playerClass;
        this.senderNamespace = senderNamespace;
    }

    @Override
    public CommandPart createPart(String name, List<? extends Annotation> modifiers) {
        return new CommandPart() {

            @Override
            public String getName() {
                    return name;
                }

                @Override
                public void parse(CommandContext context, ArgumentStack stack) {

                    System.out.println(senderClass.getName() + " - " + senderNamespace);

                    Object sender = context.getObject(senderClass, senderNamespace);

                    if (sender == null){
                        System.out.println("CommandSender, null");
                    }
                    System.out.println("Loading argument");

                    if (sender != null) {
                        if (playerClass.isInstance(sender)) {
                            context.setValue(this, sender);
                            return;
                        } else {
                            throw new ArgumentParseException(TranslatableComponent.of("sender.only-player"));
                        }
                    }
                    throw new ArgumentParseException(TranslatableComponent.of("sender.unknown"));
                }

            };
        }

}