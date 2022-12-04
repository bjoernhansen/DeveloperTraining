package training.design_pattern.extension_interface;

/* Extension interface */
interface Translatable extends Document
{
    Translatable translate(Language language);
}
