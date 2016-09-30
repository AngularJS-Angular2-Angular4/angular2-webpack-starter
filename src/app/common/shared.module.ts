import { NgModule }                     from '@angular/core';
import { FormsModule }                  from '@angular/forms';
import { CommonModule }                 from '@angular/common';
import { ContactUsComponent }           from './contact-us/contact-us.component';
import { LiveChatComponent }            from './contact-us/live-chat.component';

@NgModule({
    imports: [ FormsModule,
    CommonModule],
    exports: [ ContactUsComponent,
                LiveChatComponent ],
    declarations: [ ContactUsComponent,
                    LiveChatComponent ],
    providers: []
})
export class SharedModule { }
