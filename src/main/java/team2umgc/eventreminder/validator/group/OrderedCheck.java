package team2umgc.eventreminder.validator.group;


import jakarta.validation.GroupSequence;

@GroupSequence({FirstValidation.class, SecondValidation.class, ThirdValidation.class})
public interface OrderedCheck {
}
